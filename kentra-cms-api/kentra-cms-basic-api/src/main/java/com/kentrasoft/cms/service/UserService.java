package com.kentrasoft.cms.service;

import com.kentrasoft.cms.entity.Role;
import com.kentrasoft.cms.entity.User;
import com.kentrasoft.cms.entity.UserRole;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;

import java.util.Date;
import java.util.List;

/**
 * 描述：用户service接口
 *
 * @author zhangmengkang
 * @date 2018/5/28 10:26
 */
public interface UserService {

    /**
     * 描述：条件分页查询
     * @param page
     * @return
     */
    PageForm<User> getPageList(PageForm<User> page, String username, String telphone, Date birthdayMin, Date birthdayMax);

    /**
     * 描述：新增用户
     * @param user
     */
    BaseResult add(User user);

    /**
     * 描述：修改用户信息
     * @param user
     */
    BaseResult edit(User user);

    /**
     * 描述：删除用户
     * @param ids
     */
    String delete(String ids);

    /**
     * 描述：根据用户名查找 用户
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 描述：根据用户Id查找 用户
     * @param id
     * @return
     */
    User findById(Long id);
    
    /**
     * 更新密码
     */
    boolean updatePassword(Long userId, String resetPassword);

    /**
     * 描述：用户添加角色
     *
     * @param userId
     * @param roleIds
     */
    void userAddRole(Long userId, String roleIds);

    /**
     * 描述：根据用户Id查找角色
     *
     * @param id
     * @return
     */
    List<UserRole> findUserRoleId(Long id);

    /**
     * 描述：根据用户Id查找所有角色
     * @param id
     * @return
     */
    List<Role> selectUserWithRole(Long id);
}
