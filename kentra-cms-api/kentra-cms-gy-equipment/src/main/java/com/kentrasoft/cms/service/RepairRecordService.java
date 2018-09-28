package com.kentrasoft.cms.service;

import com.kentrasoft.cms.entity.RepairRecord;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;

/**
 * 描述：设备维护管理service 接口
 *
 * @author zhangmengkang
 * @date 2018-6-12 13:42:37
 */
public interface RepairRecordService {
    PageForm<RepairRecord> getPageList(PageForm<RepairRecord> page, String repairUserName, String repairDeviceId);

    BaseResult add(RepairRecord repairRecord);

    BaseResult delete(String ids);

    BaseResult edit(RepairRecord repairRecord);

    BaseResult findByRepairDeviceId(String repairDeviceId);
}
