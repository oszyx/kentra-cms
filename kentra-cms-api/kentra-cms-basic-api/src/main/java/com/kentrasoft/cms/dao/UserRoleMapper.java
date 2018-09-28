package com.kentrasoft.cms.dao;

import com.kentrasoft.cms.entity.UserRole;
import com.kentrasoft.cms.entity.UserRoleExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "userRoleMapper")
public interface UserRoleMapper {
    /**
     *
     * @mbg.generated 2018-06-11
     */
    long countByExample(UserRoleExample example);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int deleteByExample(UserRoleExample example);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int insert(UserRole record);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int insertSelective(UserRole record);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    List<UserRole> selectByExample(UserRoleExample example);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    UserRole selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int updateByPrimaryKeySelective(UserRole record);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int updateByPrimaryKey(UserRole record);

    void deleteByUserIds(String ids);
}