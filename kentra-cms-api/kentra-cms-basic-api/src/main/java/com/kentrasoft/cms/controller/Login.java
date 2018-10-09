package com.kentrasoft.cms.controller;


import com.kentrasoft.cms.common.cache.util.RedisUtil;
import com.kentrasoft.cms.common.util.JwtUtil;
import com.kentrasoft.cms.dao.DictMapper;
import com.kentrasoft.cms.dao.UserMapper;
import com.kentrasoft.cms.entity.Dict;
import com.kentrasoft.cms.entity.DictExample;
import com.kentrasoft.cms.entity.User;
import com.kentrasoft.cms.service.MenuService;
import com.kentrasoft.cms.service.UserService;
import com.kentrasoft.utils.tools.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/sys")
public class Login {
    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private DictMapper dictMapper;

    @Autowired
    private UserMapper userMapper;
	
	// test
    /**
     * 登陆验证
     *
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    public HashMap<String, String> userLogin(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, HttpServletResponse response) throws Exception {
        HashMap<String, String> map = new HashMap<>();
        User user = userService.findByUsername(username);
        //MD5加密验证
        if (user == null || !MD5Util.string2MD5(password).equals(user.getPassword())) {
            map.put("msg", "fail");
        } else {
            map.put("msg", "success");
            //redis存放 key：token value:user
            Map<String, Object> claims = new HashMap<>();
            claims.put("sub", user.getUsername());
            claims.put("created", new Date());
            String token = JwtUtil.generateToken(claims, "123456", 14400L * 1000);
            //不把该用户生成的token存在user里的Ext1字段中
            user.setExt1(token);
            redisUtil.set(token, user, 14400L);
            map.put("Token", token);
        }
        return map;
    }

    /**
     * token过期之后重新获取token
     *
     * @param userId
     * @param password
     * @return
     */
    @RequestMapping("/chanageToken")
    public HashMap<String, String> chanageToken(String userId, String password) {
        HashMap<String, String> map = new HashMap<>();
        if (!StringUtils.isEmpty(userId)) {
            User user = userMapper.selectByPrimaryKey(Long.parseLong(userId));
            if (user != null && user.getPassword().equals(password)) {
                Map<String, Object> claims = new HashMap<>();
                claims.put("sub", user.getUsername());
                claims.put("created", new Date());
                String token = JwtUtil.generateToken(claims, "123456", 10000L);
                //不把该用户生成的token存在user里的Ext1字段中
                user.setExt1(token);
                redisUtil.set(token, user, 10000L);
                map.put("msg", "success");
                map.put("Token", token);
            } else {
                map.put("msg", "fail");
            }
        }else {
            map.put("msg", "fail");
        }
        return map;
    }

    /**
     * 首页数据信息查询
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/loadIndex")
    public HashMap<String, Object> loadIndex(@RequestParam(value = "cookie") String KentrasoftToken) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        if (!"".equals(KentrasoftToken) && KentrasoftToken != null) {
            User user = (User) redisUtil.get(KentrasoftToken);
            //显示导航
            map.put("AllMenu", menuService.findAllMenu());
            map.put("UserMenu", menuService.findUserMenu(user.getId().toString()));
            //显示用户信息
            map.put("User", user);
        }
        return map;
    }

    /**
     * 数据字典
     * author:赵参谋
     *
     * @return
     */
    @RequestMapping("/getDict")
    public List<Dict> dictList() {
        //数据字典
        DictExample dictExample = new DictExample();
        DictExample.Criteria crit = dictExample.createCriteria();
        crit.andDictStatusEqualTo("1");
        return dictMapper.selectByExample(dictExample);
    }

    /**
     * 重置密码
     *
     * @param userId
     * @param password
     * @param resetpassword
     * @return
     */
    @RequestMapping("/resetPassword")
    public @ResponseBody
    HashMap<String, String> resetPasswor(@RequestParam String userId, @RequestParam String password,
                                         @RequestParam String resetpassword) {
        HashMap<String, String> infos = new HashMap<>();
        User user = userService.findById(Long.parseLong(userId));
//        if (user == null || !password.equals(user.getPassword())) {
        //MD5加密的密码验证
        if (user == null || !MD5Util.string2MD5(password).equals(user.getPassword())) {
            infos.put("msg", "01");//原始密码不一致
        } else {
            boolean status = userService.updatePassword(Long.parseLong(userId), resetpassword);
            if (status) {
                infos.put("msg", "02");//更新成功
            } else {
                infos.put("msg", "03");//更新失败
            }
        }
        return infos;

    }
}
