package com.kentrasoft.cms.service;

import com.kentrasoft.utils.plugin.BaseResult;

public interface CardPortDataService {
    BaseResult findByDrivingRecord(String drivingRecord);
}
