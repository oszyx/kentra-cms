package com.kentrasoft.cms.controller.role;


import com.kentrasoft.cms.common.cache.util.RedisUtil;
import com.kentrasoft.cms.dao.RoleMapper;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import com.kentrasoft.cms.entity.Menu;
import com.kentrasoft.cms.entity.Role;
import com.kentrasoft.cms.entity.RoleMenu;
import com.kentrasoft.cms.service.RoleMenuService;
import com.kentrasoft.cms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 描述：角色controller
 *
 * @author zhangmengkang
 * @date 2018/5/25 17:32
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleMenuService roleMenuService;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RedisUtil redisUtil;


    /**
     * 获取角色机构
     */
    @RequestMapping("/getroleMenu")
    public @ResponseBody
    List<Menu> getroleMenu(String id) {
        List<Menu> menus = roleService.findMenuByroleId(Long.parseLong(id));
        return menus;
    }

    /**
     * 给角色添加机构
     */
    @RequestMapping("/addRoleMenu")
    @ResponseBody
    public BaseResult<RoleMenu> addRoleMenu(Role role, String menuIds) {
        try {
            //已存在的menuID
            List<String> roleMenuList = roleMenuService.findByID(role.getId());
            //传递过来menuID
            List<Object> postMenuList = Arrays.asList(menuIds.split(","));
            //删除，差集1
            List<String> diffExist = (List<String>) this.diff(roleMenuList, postMenuList);
            if (diffExist != null && diffExist.size() > 0 && null != diffExist.get(0) && !"".equals(diffExist.get(0))) {
                for (String menuId : diffExist) {
                    this.deletRoleMenu(role, menuId);
                }
            }
            //新增差集2
            List<String> diffNotExist = (List<String>) this.diff(postMenuList, roleMenuList);
            if (diffNotExist != null && diffNotExist.size() > 0 && null != diffNotExist.get(0) && !"".equals(diffNotExist.get(0))) {
                for (String menuId : diffNotExist) {
                    this.insertRoleMenu(role, menuId);
                }
            }
            return BaseResult.success("新增成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.faild("新增失败！");
        }
    }

    //两个集合交集
    public List bothMenu(List ls1, List ls2) {
        List list = new ArrayList(Arrays.asList(new Object[ls1.size()]));
        Collections.copy(list, ls1);
        list.retainAll(ls2);
        return list;
    }

    //差集，即ls1中有，但ls2中没有的
    public List diff(List ls1, List ls2) {
        List list = new ArrayList(Arrays.asList(new Object[ls1.size()]));
        Collections.copy(list, ls1);
        list.removeAll(ls2);
        return list;
    }

    /**
     * 插入role_menu数据
     */
    public void insertRoleMenu(Role role, String menuId) {
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setRoleId(role.getId());
        roleMenu.setMenuId(Long.parseLong(menuId));
        roleMenuService.add(roleMenu);
    }

    /**
     * 删除role_menu数据
     */
    public void deletRoleMenu(Role role, String menuId) {
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setRoleId(role.getId());
        roleMenu.setMenuId(Long.parseLong(menuId));
        roleMenuService.dele(roleMenu);
    }

    /**
     * 查询roeTree
     */
    @RequestMapping("/getTreeList")
    public @ResponseBody
    List<Role> getTreeList() {
        List<Role> roles = roleService.getTreeList();
        for (Role role : roles) {
            role.setRoleTreeUrl("javascript:roleTreeOnClick(" + role.getId() + ")");
        }
        return roles;
    }

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @RequestMapping(value = "/getListPage")
    @ResponseBody
    public PageForm<Role> getPageList(PageForm<Role> page, String roleName, String roleParentId) {
        PageForm<Role> pageForm = roleService.getPageList(page, roleName, roleParentId);
        return pageForm;
    }


    /**
     * 描述：新增角色
     *
     * @param role
     * @throws Exception
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public BaseResult add(Role role) {
        try {
            //查询rolecode是否存在
            List<Role> rolelist = roleMapper.findbyRoleCode(role.getRoleCode(), "");
            if (rolelist != null && rolelist.size() > 0) {
                return BaseResult.faild("角色编号已存在");
            }
            if (null == role.getRoleParentId() || "".equals(role.getRoleParentId())) {
                role.setRoleParentId(Long.parseLong("1"));
            }
            roleService.add(role);
            redisUtil.set(role.getRoleCode(),role.getRoleName());
            return BaseResult.success("新增成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.faild("新增失败！");
        }

    }

    /**
     * 描述：修改用户信息
     *
     * @param role
     */
    @RequestMapping(value = "/edit")
    @ResponseBody
    public BaseResult edit(Role role) {
        try {
            //判断是否存在相同code
            List<Role> rolelist = roleMapper.findbyRoleCode(role.getRoleCode(), role.getId().toString());
            if (rolelist != null && rolelist.size() > 0) {
                return BaseResult.faild("角色编号已存在");
            }
            //删除缓存数据
            Role role_index = roleMapper.selectByPrimaryKey(role.getId());
            redisUtil.remove(role_index.getRoleCode());
            //新增缓存数据
            redisUtil.set(role.getRoleCode(), role.getRoleName());
            //更新数据
            roleService.edit(role);
            return BaseResult.success("修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.faild("修改失败！");
        }

    }

    /**
     * 描述：删除角色
     *
     * @param ids
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public BaseResult delete(String ids) {
        try {
            //查询删除角色下是否还有子角色，如果过有则提醒先删除子角色
            List<Role> childrenRole = roleMapper.findChildrenRole(ids);
            if (childrenRole.size() == 0) {
                //删除缓存
                List<String> roleIds = Arrays.asList(ids.split(","));
                for (String id : roleIds) {
                    Role role = roleMapper.selectByPrimaryKey(Long.parseLong(id));
                    redisUtil.remove(role.getRoleCode());
                }
                //删除角色
                roleMapper.deleteRoles(ids);
                //删除角色管理用户表（user_role）
                roleMapper.deleteUserRole(ids);
                //删除橘色管理菜单表（role_menu）
                roleMapper.deleteRoleMenu(ids);
                return BaseResult.success("删除成功");
            } else {
                return BaseResult.faild("请先删除子角色");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.faild("删除失败");
        }
    }

    /**
     * 描述：查找所有角色
     *
     * @return role
     */
    @RequestMapping(value = "findAll")
    @ResponseBody
    public BaseResult<Role> findAll() {
        List<Role> roles = roleService.findAll();
        return BaseResult.success("添加成功", roles);
    }

    /**
     * 描述：查询某个系统角色
     *
     * @return
     */
    @RequestMapping(value = "findByRelySystem")
    @ResponseBody
    public BaseResult<Role> findByRelySystem(Role role) {
        List<Role> roles = roleService.findByRelySystem(role.getRelySystem());
        return BaseResult.success("添加成功", roles);
    }

    /**
     * 描述：根据系统查询所有角色
     * @return
     */
    /*@RequestMapping(value = "findByAllRelySystem")
    @ResponseBody
    public BaseResult<Role> findByAllRelySystem(Integer x) {
        List<Role> roles = roleService.findByRelySystem(x);
        return BaseResult.success("添加成功", roles);
    }*/

}
