package com.kentrasoft.cms.service.impl;

import com.kentrasoft.cms.dao.UserMapper;
import com.kentrasoft.cms.dao.UserRoleMapper;
import com.kentrasoft.cms.entity.*;
import com.kentrasoft.cms.service.UserService;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import com.kentrasoft.utils.tools.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 描述：
 *
 * @author zhangmengkang
 * @date 2018/5/28 10:25
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 描述：条件分页查询
     *
     * @param page
     * @return
     */
    @Override
    public PageForm<User> getPageList(PageForm<User> page, String username, String telphone, Date birthdayMin, Date birthdayMax) {

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (username != "" && username != null) {
            criteria.andUsernameLike("%" + username + "%");
        }
        if (telphone != "" && telphone != null) {
            criteria.andTelphoneLike("%" + telphone + "%");
        }
        if (birthdayMin != null && birthdayMax != null) {
            criteria.andBirthdayBetween(birthdayMin, birthdayMax);
        } else if (birthdayMin != null && birthdayMax == null) {
            criteria.andBirthdayGreaterThanOrEqualTo(birthdayMin);
        } else if (birthdayMin == null && birthdayMax != null) {
            criteria.andBirthdayLessThanOrEqualTo(birthdayMax);
        }
        //查询所有的数据数量
        long userCount = userMapper.countByExample(userExample);

        //分页查询所有的数据
        userExample.setLimitStart((page.getPage() - 1) * page.getLimit());
        userExample.setLimitEnd(page.getLimit());
        List<User> users = userMapper.selectByExample(userExample);

        //回写内容
        page.setCount((int) userCount);
        page.setData(users);

        return page;
    }

    /**
     * 描述：新增用户
     *
     * @param user
     */
    @Override
    public BaseResult add(User user) {
        //设置查询条件  判断姓名重复
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria1 = userExample.createCriteria();
        criteria1.andUsernameEqualTo(user.getUsername());
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() > 0) {
            return BaseResult.faild("用户名重复，请重新输入！");
        }
        //设置查询条件  判断电话重复
        UserExample userExample2 = new UserExample();
        UserExample.Criteria criteria2 = userExample2.createCriteria();
        criteria2.andIdentityCardEqualTo(user.getIdentityCard());
        List<User> users1 = userMapper.selectByExample(userExample2);
//        if (users.size() > 0) {
//            return BaseResult.faild("身份证号码重复，请重新输入！");
//        }
        // 修改代码
        if (users1.size() > 0) {
            return BaseResult.faild("身份证号码重复，请重新输入！");
        }
        //MD5加密密码
        user.setPassword(MD5Util.string2MD5(user.getPassword()));
        user.setCreateTime(new Date());
        userMapper.insertSelective(user);
        return BaseResult.success("添加成功");
    }

    /**
     * 描述：修改用户信息
     *
     * @param user
     */
    @Override
    public BaseResult edit(User user) {
        User userDB = userMapper.selectByPrimaryKey(user.getId());

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria1 = userExample.createCriteria();
        criteria1.andUsernameEqualTo(user.getUsername());
        List<User> users = userMapper.selectByExample(userExample);

        //判断用户名重复
        if (users.size() > 1) {
            return BaseResult.faild("用户名重复，请重新输入！");
        } else if (users.size() == 1) {
            if (!users.get(0).getId().equals(user.getId())) {
                return BaseResult.faild("用户名重复，请重新输入！");
            }
        }

        UserExample userExampleIDC = new UserExample();
        UserExample.Criteria criteria1IDC = userExampleIDC.createCriteria();
        criteria1IDC.andIdentityCardEqualTo(user.getIdentityCard());
        List<User> usersIDC = userMapper.selectByExample(userExampleIDC);

        //判断身份证重复
        if (usersIDC.size() > 1) {
            return BaseResult.faild("用户身份证重复，请重新输入！");
        } else if (usersIDC.size() == 1) {
            if (!usersIDC.get(0).getId().equals(user.getId())) {
                return BaseResult.faild("用户身份证重复，请重新输入！");
            }
        }

        if (user.getPassword() != null && !user.getPassword().equals("")) {
            user.setPassword(MD5Util.string2MD5(user.getPassword()));
        }
        userMapper.updateByPrimaryKeySelective(user);
        return BaseResult.success("修改用户信息成功！");
    }

    /**
     * 描述：批量删除
     *
     * @param ids
     */
    @Override
    public String delete(String ids) {
        try {
            userRoleMapper.deleteByUserIds(ids);
            userMapper.deleteByPKs(ids);
            return "200";
        } catch (Exception e) {
            return e.getMessage();
        }
    }


    /**
     * 描述：根据用户名查找用户
     *
     * @param username
     * @return
     */
    @Override
    public User findByUsername(String username) {
        if (username == null || username == "") {
            return null;
        }
        //设置查询条件
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        if (users == null || users.size() < 1) {
            return null;
        } else {
            return users.get(0);
        }
    }

    /**
     * 描述：根据用户Id查找 用户
     *
     * @param id
     * @return
     */
    @Override
    public User findById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新密码
     */
    @Override
    public boolean updatePassword(Long userId, String resetPassword) {
        try {
//            userMapper.resetPassword(userId, resetPassword);
            //MD5加密
            userMapper.resetPassword(userId, MD5Util.string2MD5(resetPassword));
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    /**
     * 描述：用户添加角色
     *
     * @param userId
     * @param roleIds
     */
    @Override
    public void userAddRole(Long userId, String roleIds) {
        //查找用户权限  删除原有权限
        List<UserRole> userRoles = findUserRoleId(userId);
        for (UserRole userRole : userRoles) {
            UserRoleExample userRoleExample = new UserRoleExample();
            UserRoleExample.Criteria criteria = userRoleExample.createCriteria();
            criteria.andUserIdEqualTo(userRole.getUserId());
            userRoleMapper.deleteByExample(userRoleExample);
        }
        //添加新权限
        UserRole ur = new UserRole();
        ur.setUserId(userId);
        if (roleIds != null && !"".equals(roleIds)) {
            String[] ids = roleIds.split(",");
            for (String id : ids) {
                ur.setRoleId(Long.parseLong(id));
                userRoleMapper.insert(ur);
            }
        }
    }

    /**
     * 描述：根据用户Id查找角色
     *
     * @param id
     */
    @Override
    public List<UserRole> findUserRoleId(Long id) {
        //设置查询条件
        UserRoleExample userRoleExample = new UserRoleExample();
        UserRoleExample.Criteria criteria = userRoleExample.createCriteria();
        criteria.andUserIdEqualTo(id);
        List<UserRole> userRoles = userRoleMapper.selectByExample(userRoleExample);
        return userRoles;
    }

    /**
     * 描述：根据用户Id查找所有角色
     *
     * @param id
     * @return
     */
    @Override
    public List<Role> selectUserWithRole(Long id) {
        List<Role> roles = userMapper.selectUserWithRole(id);
        return roles;
    }

}
