package com.kentrasoft.cms.dao;

import com.kentrasoft.cms.entity.ControllerManagement;
import com.kentrasoft.cms.entity.ControllerManagementExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "controllerManagementMapper")
public interface ControllerManagementMapper {
    /**
     *
     * @mbg.generated 2018-06-13
     */
    long countByExample(ControllerManagementExample example);

    /**
     *
     * @mbg.generated 2018-06-13
     */
    int deleteByExample(ControllerManagementExample example);

    /**
     *
     * @mbg.generated 2018-06-13
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2018-06-13
     */
    int insert(ControllerManagement record);

    /**
     *
     * @mbg.generated 2018-06-13
     */
    int insertSelective(ControllerManagement record);

    /**
     *
     * @mbg.generated 2018-06-13
     */
    List<ControllerManagement> selectByExample(ControllerManagementExample example);

    /**
     *
     * @mbg.generated 2018-06-13
     */
    ControllerManagement selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2018-06-13
     */
    int updateByExampleSelective(@Param("record") ControllerManagement record, @Param("example") ControllerManagementExample example);

    /**
     *
     * @mbg.generated 2018-06-13
     */
    int updateByExample(@Param("record") ControllerManagement record, @Param("example") ControllerManagementExample example);

    /**
     *
     * @mbg.generated 2018-06-13
     */
    int updateByPrimaryKeySelective(ControllerManagement record);

    /**
     *
     * @mbg.generated 2018-06-13
     */
    int updateByPrimaryKey(ControllerManagement record);

    void deleteByPKs(String ids);
}