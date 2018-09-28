package com.kentrasoft.cms.service;

import com.kentrasoft.cms.entity.ControllerManagement;
import com.kentrasoft.cms.entity.DeviceManagement;
import com.kentrasoft.cms.entity.RepairRecord;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;

import java.util.List;

/**
 * 5.8G设备管理
 *
 * @author 赵参谋
 */
@SuppressWarnings("rawtypes")
public interface DeviceManagementService {

    /**
     * 分页查询
     * author:赵参谋
     *
     * @param page
     * @param name
     * @return
     */
    PageForm<DeviceManagement> getPageList(PageForm<DeviceManagement> page, String name, String searchNo, String serchStatus, String ids);

    /**
     * 查询控制设备
     * author:赵参谋
     *
     * @return
     */
    List<ControllerManagement> getControllerList(String id);

    /**
     * 新增设备管理
     * author:赵参谋
     *
     * @param device
     * @return
     */
    BaseResult insertDevice(DeviceManagement device);

    /**
     * 删除设备信息
     * author:赵参谋
     *
     * @param ids
     * @return
     */
    BaseResult deleteDevice(String ids);

    /**
     * 更新设备信息
     * author:赵参谋
     *
     * @param device
     * @return
     */
    BaseResult updateDevice(DeviceManagement device);

    /**
     * 插入维修信息
     * author:赵参谋
     *
     * @param repaireRecord
     * @return
     */
    BaseResult insertReapirRecord(RepairRecord repaireRecord);

    /**
     * 导出设备信息
     * author:赵参谋
     *
     * @return
     */
    List<DeviceManagement> exportDeviceInfos(String serchnameParam, String searchNoParam, String serchStatusParam);

    /**
     * 获取维修记录信息
     * author:赵参谋
     *
     * @return
     */
    List<RepairRecord> getRepairRecord(String DeviceId);

    /**
     * 获取5.8g设备统计数据
     *
     * @param year 年代
     * @return
     */
    BaseResult getDeviceCount(String year);
}
