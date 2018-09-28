package com.kentrasoft.cms.dao;

import com.kentrasoft.cms.entity.Menu;
import com.kentrasoft.cms.entity.Role;
import com.kentrasoft.cms.entity.RoleExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "roleMapper")
public interface RoleMapper {
    /**
     *
     * @mbg.generated 2018-06-11
     */
    long countByExample(RoleExample example);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int deleteByExample(RoleExample example);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int insert(Role record);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int insertSelective(Role record);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    List<Role> selectByExample(RoleExample example);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    Role selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int updateByPrimaryKey(Role record);
    /**
	 * 删除角色
	 */
    void deleteRoles(String ids);
    
    void deleteUserRole(String ids);
    
    void deleteRoleMenu(String ids);
    
    /**
	 * 查询roleTreeList
	 */
    List<Role> getTreeList();
    
    /**
	 * 根据角色id查询menu
	 */
	List<Menu> findMenuAndId(Long id);
	
	/**
	 * 查询角色id下是否有子角色
	 */
	List<Role> findChildrenRole(String ids);
	/**
	 * 根据角色code查询
	 */
	List<Role> findbyRoleCode(@Param("roleCode") String roleCode, @Param("roleId") String roleId);
}