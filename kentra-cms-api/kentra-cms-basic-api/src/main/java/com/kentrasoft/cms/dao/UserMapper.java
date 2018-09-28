package com.kentrasoft.cms.dao;

import com.kentrasoft.cms.entity.Role;
import com.kentrasoft.cms.entity.User;
import com.kentrasoft.cms.entity.UserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "userMapper")
public interface UserMapper {
    /**
     *
     * @mbg.generated 2018-06-11
     */
    long countByExample(UserExample example);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int deleteByExample(UserExample example);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int insert(User record);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int insertSelective(User record);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    List<User> selectByExample(UserExample example);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    User selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int updateByPrimaryKeySelective(User record);

    /**
     *
     * @mbg.generated 2018-06-11
     */
    int updateByPrimaryKey(User record);

    void resetPassword(@Param("userId") Long userId, @Param("resetPassword") String resetPassword);

    void deleteByPKs(String ids);

    List<Role> selectUserWithRole(Long userId);
}