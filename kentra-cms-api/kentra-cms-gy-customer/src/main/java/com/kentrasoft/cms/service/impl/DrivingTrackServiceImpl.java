package com.kentrasoft.cms.service.impl;

import com.kentrasoft.cms.dao.DrivingTrackMapper;
import com.kentrasoft.cms.entity.DrivingTrack;
import com.kentrasoft.cms.entity.dto.RecordDetails;
import com.kentrasoft.cms.service.DrivingTrackService;
import com.kentrasoft.utils.plugin.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrivingTrackServiceImpl implements DrivingTrackService {
    @Autowired
    private DrivingTrackMapper drivingTrackMapper;

    @Override
    public BaseResult findByDrivingRecord(String drivingRecord) {
        List<RecordDetails> recordDetails = drivingTrackMapper.findByDrivingRecord(drivingRecord);
        return BaseResult.success("查询成功",recordDetails);
    }

    /**
     * 存储5.8G设备采集数据
     */
	@Override
	public void save(DrivingTrack drivingTrack) {
		drivingTrackMapper.insert(drivingTrack);		
	}

	@Override
	public List<DrivingTrack> queryDrivingTrackBylicenseNum(String licenseNum,String drivingRecord) {
		List<DrivingTrack> list = drivingTrackMapper.queryDrivingTrackBylicenseNum(licenseNum,drivingRecord);
		return list;
	}
}
