package com.kentrasoft.cms.controller.user;

import com.kentrasoft.cms.entity.Role;
import com.kentrasoft.cms.entity.User;
import com.kentrasoft.cms.entity.UserRole;
import com.kentrasoft.cms.service.UserService;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 描述：用户controller
 *
 * @author zhangmengkang
 * @date 2018-5-25 17:47:34
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 分页查询
     *
     * @param page
     * @param httpRequest
     * @return
     */
    @RequestMapping(value = "/getListPage", method = RequestMethod.GET)
    @ResponseBody
    public PageForm<User> getPageList(PageForm<User> page, HttpServletRequest httpRequest) {
        String username = httpRequest.getParameter("username");
        String telphone = httpRequest.getParameter("telphone");
        String birthdayMinS = httpRequest.getParameter("birthdayMin");
        String birthdayMaxS = httpRequest.getParameter("birthdayMax");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //必须捕获异常
        Date birthdayMin = null;
        Date birthdayMax = null;

        if (birthdayMinS != "" && birthdayMinS != null) {
            try {
                birthdayMin = simpleDateFormat.parse(birthdayMinS);
            } catch (Exception px) {
                px.getMessage();
            }
        }
        if (birthdayMaxS != "" && birthdayMaxS != null) {
            try {
                birthdayMax = simpleDateFormat.parse(birthdayMaxS);
            } catch (Exception px) {
                px.getMessage();
            }
        }
        PageForm<User> pageForm = userService.getPageList(page, username, telphone, birthdayMin, birthdayMax);
        return pageForm;
    }

    /**
     * 描述：新增用户
     *
     * @param user
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult add(User user) {
        return userService.add(user);
    }

    /**
     * 描述：修改用户信息
     *
     * @param user
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult edit(User user) {
        user.setUpdateTime(new Date());
        return userService.edit(user);
    }

    /**
     * 描述：删除用户
     *
     * @param ids
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public BaseResult delete(String ids) {
        String status = userService.delete(ids);
        if (!status.equals("200")) {
            return BaseResult.faild(status);
        }
        return BaseResult.success("删除成功");
    }

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    @RequestMapping(value = "/findByUsername")
    @ResponseBody
    public BaseResult findByUsername(String username) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return BaseResult.faild("查询用户不存在！");
        } else {
            return BaseResult.success("查询成功！", user);
        }
    }

    /**
     * 根据用户Id查询用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/findById")
    @ResponseBody
    public User findById(Long id) {
        User user = userService.findById(id);
        return user;
    }

    /**
     * 描述：用户添加角色
     *
     * @param userId
     * @param roleIds
     * @return
     */
    @RequestMapping(value = "/userAddRoles")
    @ResponseBody
    public BaseResult userAddRole(Long userId, String roleIds) {
        if (userId == null) {
            return BaseResult.faild("用户信息错误！");
        }
        /*if (roleIds == null || roleIds == "") {
            return BaseResult.faild("请至少添加一个角色！");
        }*/
        userService.userAddRole(userId, roleIds);
        return BaseResult.success("赋权成功");
    }


    /**
     * 描述：根据用户Id查找角色_用户表
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/findUserRole")
    @ResponseBody

    public BaseResult findUserRoleId(Long id) {
        List<UserRole> userRole = userService.findUserRoleId(id);
        return BaseResult.success("删除成功", userRole);
    }

    /**
     * 描述：根据用户Id查找所有角色
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/selectUserWithRole")
    @ResponseBody
    public BaseResult selecetUserWithRole(Long id) {
        List<Role> role = userService.selectUserWithRole(id);
        return BaseResult.success("删除成功", role);
    }
}
