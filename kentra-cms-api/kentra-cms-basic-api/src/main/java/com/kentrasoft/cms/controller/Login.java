package com.kentrasoft.cms.controller;

import com.kentrasoft.base.controller.BaseController;
import com.kentrasoft.cms.common.cache.util.RedisUtil;
import com.kentrasoft.cms.common.util.JwtUtil;
import com.kentrasoft.cms.common.util.MD5Util;
import com.kentrasoft.cms.model.Menu;
import com.kentrasoft.cms.model.Role;
import com.kentrasoft.cms.model.User;
import com.kentrasoft.cms.service.MenuService;
import com.kentrasoft.cms.service.UserService;
import com.kentrasoft.utils.RightsUtils.RightsHelper;
import com.kentrasoft.utils.plugin.BaseResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/cms")
public class Login extends BaseController {
    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 描述:登陆验证
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResult login(@RequestBody User user) {
        BaseResult baseResult;
        if (StringUtils.isNotEmpty(user.getUsername()) && StringUtils.isNotEmpty(user.getPassword())) {
            //对password进行md5加密
            String md5Pd = MD5Util.string2MD5(user.getPassword());
            Map<String, Object> params = new HashMap<>();
            params.put("username", user.getUsername());
            params.put("password", md5Pd);
            User u = userService.findUserByUserName(params);
            if (u != null) {
                //处理 加权和 之后的数据
                List userMenuList = getUserPermission(u.getUserRights());
                //获取每个菜单详细信息
                params.put("idList", userMenuList);
                List<Menu> menus = menuService.userMenuTree(params);
                //生成jwt token
                Map<String, Object> claims = new HashMap<>();
                claims.put("sub", u.getUsername());
                claims.put("created", new Date());
                String token = JwtUtil.generateToken(claims, "woShiShuaiGe", 14400L * 1000);
                //把该用户生成的token存在user里的userToken字段中,menus存在userMenus中,然后以user对象的形式存在redis中
                u.setUserToken(token);
                u.setUserMenus(menus);
                redisUtil.set(token, u, 14400L);
                List<Object> result = new ArrayList<>();
                result.add(token);
                result.add(menus);
                baseResult = BaseResult.success("请求成功!", result);
            } else {
                baseResult = BaseResult.success("用户账号或密码不正确!");
            }
        } else {
            baseResult = BaseResult.faild("账号密码为空!");
        }
        return baseResult;
    }

    /**
     * token过期之后重新获取token
     *
     * @param userId   用户id
     * @param username 用户名
     * @return
     */
    //TODO （暂定） 逻辑还未定   待页面请求方式决定
    @RequestMapping("/chanageToken")
    public BaseResult chanageToken(String userId, String username) {
        BaseResult baseResult = null;
        if (!StringUtils.isEmpty(userId)) {

        } else {
            baseResult = BaseResult.faild("");
        }
        return baseResult;
    }

    /**
     * 处理加权和数据，获取用户绑定的角色id
     *
     * @param userRights
     * @return
     */
    public List getUserPermission(String userRights) {
        //先获取登录用户所有的角色id
        List<Role> allRole = (List) redisUtil.get("allRole");
        List<Role> roleList = new ArrayList<>();
        for (int i = 0; i < allRole.size(); i++) {
            boolean b = RightsHelper.testRights(userRights, allRole.get(i).getId().toString());
            if (b) {
                roleList.add(allRole.get(i));
            }
        }
        //根据获取到的角色id再获取登录用户的所有权限
        List<Menu> allMenu = (List) redisUtil.get("allMenu");
        List menuList = new ArrayList<>();
        for (int i = 0; i < roleList.size(); i++) {
            for (int j = 0; j < allMenu.size(); j++) {
                boolean b = RightsHelper.testRights(roleList.get(i).getRoleRights(), allMenu.get(j).getId().toString());
                if (b) {
                    menuList.remove(allMenu.get(j).getId());
                    menuList.add(allMenu.get(j).getId());
                }
            }
        }
        return menuList;
    }

    /**
     * 描述:初始化页面
     *
     * @return
     */
    @RequestMapping("/init")
    public HashMap<String, String> init() {

        return null;
    }

}
