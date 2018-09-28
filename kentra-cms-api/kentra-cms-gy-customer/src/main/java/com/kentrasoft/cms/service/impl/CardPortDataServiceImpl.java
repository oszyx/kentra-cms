package com.kentrasoft.cms.service.impl;

import com.kentrasoft.cms.dao.CardPortDataMapper;
import com.kentrasoft.cms.entity.CardPortData;
import com.kentrasoft.cms.service.CardPortDataService;
import com.kentrasoft.utils.plugin.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardPortDataServiceImpl implements CardPortDataService {
    @Autowired
    private CardPortDataMapper cardPortDataMapper;

    @Override
    public BaseResult findByDrivingRecord(String drivingRecord) {
       List<CardPortData> cardPortDatas = cardPortDataMapper.findByDrivingRecord(drivingRecord);
        return BaseResult.success("查询成功",cardPortDatas);
    }
}
