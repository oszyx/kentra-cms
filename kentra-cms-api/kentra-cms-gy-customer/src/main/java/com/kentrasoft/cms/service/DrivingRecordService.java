package com.kentrasoft.cms.service;

import com.kentrasoft.cms.entity.DrivingRecord;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;

import java.util.List;

public interface DrivingRecordService {
	
	/**
     * 描述：删除行驶记录
     *
     * @param ids
     */
    String delete(String ids);

	/**
     * 查询行驶记录数据列表
     */
	PageForm<DrivingRecord> queryDrivingList(PageForm<DrivingRecord> page, String licenseNum, String entranceName, String exitName);
	
	/**
	 * 存储行驶记录
	 */
	void add(DrivingRecord drivingRecord);

    BaseResult findByCustomerId(Long customerId);
    
    /**
     * 通过车牌查询行驶记录
     * @param licenseNum
     * @return
     */
    List<DrivingRecord> getLicenseNum(String licenseNum);
}
