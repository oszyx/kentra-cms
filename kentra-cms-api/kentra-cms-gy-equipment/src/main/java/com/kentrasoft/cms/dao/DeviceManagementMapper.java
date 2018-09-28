package com.kentrasoft.cms.dao;

import com.kentrasoft.cms.entity.DeviceManagement;
import com.kentrasoft.cms.entity.DeviceManagementExample;
import com.kentrasoft.cms.entity.RepairRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "deviceManagementMapper")
public interface DeviceManagementMapper {
    /**
     *
     * @mbg.generated 2018-06-14
     */
    long countByExample(DeviceManagementExample example);

    /**
     *
     * @mbg.generated 2018-06-14
     */
    int deleteByExample(DeviceManagementExample example);

    /**
     *
     * @mbg.generated 2018-06-14
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2018-06-14
     */
    int insert(DeviceManagement record);

    /**
     *
     * @mbg.generated 2018-06-14
     */
    int insertSelective(DeviceManagement record);

    /**
     *
     * @mbg.generated 2018-06-14
     */
    List<DeviceManagement> selectByExample(DeviceManagementExample example);

    /**
     *
     * @mbg.generated 2018-06-14
     */
    DeviceManagement selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2018-06-14
     */
    int updateByExampleSelective(@Param("record") DeviceManagement record, @Param("example") DeviceManagementExample example);

    /**
     *
     * @mbg.generated 2018-06-14
     */
    int updateByExample(@Param("record") DeviceManagement record, @Param("example") DeviceManagementExample example);

    /**
     *
     * @mbg.generated 2018-06-14
     */
    int updateByPrimaryKeySelective(DeviceManagement record);

    /**
     *
     * @mbg.generated 2018-06-14
     */
    int updateByPrimaryKey(DeviceManagement record);
    
    /**
     * 查询维修记录
     *author:赵参谋
     * @return
     */
    List<RepairRecord> selectRepairRecord(String DeviceId);
    
    /**
     * 查询所有设备信息
     */
    List<DeviceManagement> selectDeviceStatsus();
    
    /**
     * 设备状态更新
     */
    void updateDeviceStatus(@Param("id") String id, @Param("deviceStatus") String deviceStatus);

    /**
     * 根据设备code查询
     */
    List<DeviceManagement> querybyDeviceCode(@Param("deviceCode") String deviceCode, @Param("exceptDeviceId") String exceptDeviceId);

    /**
     * 查询导出数据
     */
    List<DeviceManagement> selectDeviceManagement();
    List<DeviceManagement> selectDeviceManagementBykey(@Param("serchnameParam") String serchnameParam, @Param("searchNoParam") String searchNoParam, @Param("serchStatusParam") String serchStatusParam);

    /**
     * 获取5.8g设备统计数据
     * @param year
     * @return
     */
    List<DeviceManagement> getDeviceCount(String year);
}