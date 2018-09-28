package com.kentrasoft.cms.dao;

import org.apache.ibatis.annotations.Param;

public interface DeviceMapper {

    //查询设备信息
    int queryDevice(@Param("deviceCode") String deviceCode, @Param("deviceGisX") String deviceGisX, @Param("deviceGisY") String deviceGisY);

    //更新设备信息
    void updateDevice(@Param("deviceCode") String deviceCode, @Param("deviceGisX") String deviceGisX, @Param("deviceGisY") String deviceGisY);
}
