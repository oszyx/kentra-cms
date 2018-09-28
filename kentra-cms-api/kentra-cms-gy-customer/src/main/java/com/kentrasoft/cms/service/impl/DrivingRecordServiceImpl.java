package com.kentrasoft.cms.service.impl;

import com.kentrasoft.cms.common.cache.util.RedisUtil;
import com.kentrasoft.cms.dao.DrivingRecordMapper;
import com.kentrasoft.cms.entity.DrivingRecord;
import com.kentrasoft.cms.entity.DrivingRecordExample;
import com.kentrasoft.cms.entity.DrivingRecordExample.Criteria;
import com.kentrasoft.cms.service.DrivingRecordService;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrivingRecordServiceImpl implements DrivingRecordService {

    @Autowired
    private DrivingRecordMapper drivingRecordMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public PageForm<DrivingRecord> queryDrivingList(PageForm<DrivingRecord> page, String licenseNum, String entranceName, String exitName) {
        DrivingRecordExample drivingRecordExample = new DrivingRecordExample();
        Criteria crit = drivingRecordExample.or();
        if (licenseNum != null && licenseNum != "") {
            crit.andLicenseNumLike("%" + licenseNum + "%");
        }
        if (entranceName != null && entranceName != "") {
            crit.andEntranceNameLike("%" + entranceName + "%");
        }
        if (exitName != null && exitName != "") {
            crit.andExitNameLike("%" + exitName + "%");
        }
        //是否显示三天后数据
        if ("record_page_type2".equals(redisUtil.get("driving_record_pagetype"))) {
            crit.andEntranceNameNotEqualTo("暂无数据");
        }
        drivingRecordExample.or(crit);
        //查询所有的数据数量
        long DrivingRecordCount = drivingRecordMapper.countByExample(drivingRecordExample);
        //分页查询所有的数据
        drivingRecordExample.setLimitStart((page.getPage() - 1) * page.getLimit());
        drivingRecordExample.setLimitEnd(page.getLimit());

        List<DrivingRecord> dList = drivingRecordMapper.selectByExample(drivingRecordExample);

        //回写内容
        page.setCount((int) DrivingRecordCount);
        page.setData(dList);
        return page;
    }

    @Override
    public void add(DrivingRecord drivingRecord) {
        drivingRecordMapper.insert(drivingRecord);

    }

    @Override
    public BaseResult findByCustomerId(Long customerId) {
        List<DrivingRecord> drivingRecords = drivingRecordMapper.findByCustomerId(customerId);
        return BaseResult.success("查询成功", drivingRecords);
    }

    @Override
    public String delete(String ids) {
        try {
            drivingRecordMapper.deleteByPKs(ids);
            return "200";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public List<DrivingRecord> getLicenseNum(String licenseNum) {
        return drivingRecordMapper.selectDrivingRecordBylicenseNum(licenseNum);

    }
}
