package com.kentrasoft.cms.service;


import com.kentrasoft.cms.entity.Menu;
import com.kentrasoft.cms.entity.Role;
import com.kentrasoft.utils.plugin.PageForm;

import java.util.List;

/**
 * 描述：角色Service 接口
 *
 * @author zhangmengkang
 * @date 2018/5/28 10:28
 */
public interface RoleService {
	/**
	 * 根据角色id查询menu
	 */
	List<Menu> findMenuByroleId(Long id);
	
	/**
	 * 删除角色
	 */
	String delete(String ids);
	
	/**
	 * 查询roleTreeList
	 */
	List<Role> getTreeList();

    /**
     * 描述：查找所有角色
     * @return
     */
    List<Role> findAll();

    /**
     * 描述：条件分页查询
     * @param page
     * @return
     */
    PageForm<Role> getPageList(PageForm<Role> page, String roleName, String roleParentId);

    /**
     * 描述：新增角色
     * @param role
     */
    void add(Role role);

    /**
     * 描述：修改角色信息
     * @param role
     */
    void edit(Role role);

    /**
     * 描述：删除角色
     * @param ids
     */
   /* String delete(String ids);*/

    /**
     * 描述：查询某个系统角色
     * @param relySystem
     * @return  List<Role>
     */
    List<Role> findByRelySystem(Integer relySystem) ;

}
