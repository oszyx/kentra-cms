package com.kentrasoft.cms.service;

import com.kentrasoft.cms.entity.ControllerManagement;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;

/**
 * 描述：控制器管理服务接口
 *
 * @author zmk
 * @date 2018-6-12 13:42:37
 */
public interface ControllerManagementService {

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    PageForm<ControllerManagement> getPageList(PageForm<ControllerManagement> page, String name, String controllerCode, String controllerStatus, String extends3);

    /**
     * 描述：添加控制器
     * @param controllerManagement
     */
    BaseResult add(ControllerManagement controllerManagement);

    /**
     * 描述：删除控制器
     *
     * @param ids
     */
    BaseResult delete(String ids);

    /**
     * 描述：修改控制器信息
     *
     * @param controllerManagement
     */
    BaseResult edit(ControllerManagement controllerManagement);

    /**
     * 描述：根据控制器编号查找控制器设备
     *
     * @param controllerCode
     */
    BaseResult<ControllerManagement> findByControllerCode(String controllerCode);

    /**
     * 描述：根据设备编号 修改设备状态
     *
     * @param repairDeviceId
     * @param repairStatus
     */
    void updataStatus(String repairDeviceId, String repairStatus);
}
