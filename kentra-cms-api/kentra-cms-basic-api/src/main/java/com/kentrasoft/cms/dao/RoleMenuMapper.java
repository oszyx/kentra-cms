package com.kentrasoft.cms.dao;

import com.kentrasoft.cms.entity.RoleMenu;
import com.kentrasoft.cms.entity.RoleMenuExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "roleMenuMapper")
public interface RoleMenuMapper {
    /**
     *
     * @mbg.generated 2018-06-11
     */
    long countByExample(RoleMenuExample example);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int deleteByExample(RoleMenuExample example);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int insert(RoleMenu record);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int insertSelective(RoleMenu record);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    List<RoleMenu> selectByExample(RoleMenuExample example);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    RoleMenu selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int updateByExampleSelective(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int updateByExample(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int updateByPrimaryKeySelective(RoleMenu record);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int updateByPrimaryKey(RoleMenu record);

    List<String> findByRoleID(Long id);

    void addRoleMenu(RoleMenu roleMenu);
    
    void deleRoleMenu(RoleMenu roleMenu);
    
}