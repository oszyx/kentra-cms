package com.kentrasoft.cms.service;

import com.kentrasoft.cms.entity.DrivingTrack;
import com.kentrasoft.utils.plugin.BaseResult;

import java.util.List;

public interface DrivingTrackService {

    BaseResult findByDrivingRecord(String drivingRecord);
    
    /**
     * 存储5.8G设备采集数据
     */
    void save(DrivingTrack drivingTrack);
    
  //根据车牌号查询行驶轨迹
    List<DrivingTrack> queryDrivingTrackBylicenseNum(String licenseNum, String drivingRecord);
}
