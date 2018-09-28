package com.kentrasoft.cms.service.impl;

import com.kentrasoft.cms.dao.RoleMapper;
import com.kentrasoft.cms.entity.Menu;
import com.kentrasoft.cms.entity.Role;
import com.kentrasoft.cms.entity.RoleExample;
import com.kentrasoft.cms.service.RoleService;
import com.kentrasoft.utils.plugin.PageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 描述：
 *
 * @author zhangmengkang
 * @date 2018/5/28 10:59
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    
    /**
	 * 根据角色id查询menu
	 */
    public List<Menu> findMenuByroleId(Long id){
    	return roleMapper.findMenuAndId(id);
    }
    
    /**
     * 删除角色
     */
    @Override
    public  String delete(String ids) {
    	try {
    		//查询删除角色下是否还有子角色，如果过有则提醒先删除子角色
    		List<Role> childrenRole=roleMapper.findChildrenRole(ids);
    		if(childrenRole.size()==0) {
    			//删除角色
    			roleMapper.deleteRoles(ids);
    			//删除角色管理用户表（user_role）
    			roleMapper.deleteUserRole(ids);
    			//删除橘色管理菜单表（role_menu）
    			roleMapper.deleteRoleMenu(ids);
    			return "200";
    		}else {
    		    return "400";	
    		}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "300";
		}
    }
    /**
     * 查询roleTreeList
     */
    @Override
    public List<Role> getTreeList() {
    	return roleMapper.getTreeList();
    }

    /**
     * 描述：条件分页查询
     *
     * @param page
     * @return
     */
    @Override
    public PageForm<Role> getPageList(PageForm<Role> page,String roleName,String roleParentId) {
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        if(roleName!=""&&roleName!=null){
            criteria.andRoleNameLike("%"+roleName+"%");
        }
        if(!"".equals(roleParentId) && roleParentId!=null) {
        	criteria.andRoleParentIdEqualTo(Long.parseLong(roleParentId));
        }
        //查询所有的数据数量
        long roleCount = roleMapper.countByExample(roleExample);

        //分页查询所有的数据
        roleExample.setLimitStart((page.getPage() - 1) * page.getLimit());
        roleExample.setLimitEnd(page.getLimit());
        List<Role> roles = roleMapper.selectByExample(roleExample);

        //回写内容
        page.setCount((int) roleCount);
        page.setData(roles);

        return page;
    }

    /**
     * 描述：新增角色
     *
     * @param role
     */
    @Override
    public void add(Role role) {
        roleMapper.insertSelective(role);
    }

    /**
     * 描述：修改角色信息
     *
     * @param role
     */
    @Override
    public void edit(Role role) {
        roleMapper.updateByPrimaryKeySelective(role);
    }

    /**
     * 描述：批量删除
     *
     * @param ids
     */
    /*@Override
    public String delete(String ids) {
        try {
            roleMapper.deleteByUserIds(ids);
            roleMapper.deleteByPKs(ids);
            return "200";
        } catch (Exception e) {
            return e.getMessage();
        }
    }*/

    /**
     * 描述：查询所有角色
     * @return
     */
    @Override
    public List<Role> findAll() {
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        List<Role> roles = roleMapper.selectByExample(roleExample);
        return roles;
    }

    /**
     * 描述：查询某个系统角色
     */
    @Override
    public List<Role> findByRelySystem(Integer relySystem) {
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andRelySystemEqualTo(relySystem);
        List<Role> roles = roleMapper.selectByExample(roleExample);
        return roles;
    }
}