/**
 * 5.8G设备处理
 * Author:赵参谋
 * Date:2018-06-14
 */
package com.kentrasoft.cms.web.controller;

import com.kentrasoft.cms.common.cache.util.RedisUtil;
import com.kentrasoft.cms.dao.DeviceManagementMapper;
import com.kentrasoft.cms.entity.ControllerManagement;
import com.kentrasoft.cms.entity.DeviceManagement;
import com.kentrasoft.cms.entity.RepairRecord;
import com.kentrasoft.cms.service.DeviceManagementService;
import com.kentrasoft.utils.exportExcel.ExportExcelUtils;
import com.kentrasoft.utils.exportExcel.bean.ExcelData;
import com.kentrasoft.utils.plugin.BaseController;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import com.kentrasoft.utils.uuid.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/device")
@SuppressWarnings("rawtypes")
public class DeviceManagementController extends BaseController {

    @Autowired
    private DeviceManagementService deviceManagementService;

    @Autowired
    private DeviceManagementMapper deviceManagementMapper;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 设备管理查询方法
     * param name:设备名称
     * author:赵参谋
     *
     * @param page
     * @return
     */
    @RequestMapping("/getListPage")
    public PageForm<DeviceManagement> getPageList(PageForm<DeviceManagement> page, String serchname, String searchNo, String serchStatus, String ids) {
        PageForm<DeviceManagement> pagefrom = deviceManagementService.getPageList(page, serchname, searchNo, serchStatus, ids);
        return pagefrom;

    }

    /**
     * 获取所属设备
     * author:赵参谋
     */
    @RequestMapping("/getDeviceBelEqu")
    public List<ControllerManagement> getDeviceBelEquSelect(String id) {
        List<ControllerManagement> controllerList = deviceManagementService.getControllerList(id);
        return controllerList;
    }

    /**
     * 新增设备管理
     * author:赵参谋
     *
     * @param deviceManagement
     * @return
     */
    @RequestMapping("/insertDevice")
    public BaseResult insertDeviceManagement(DeviceManagement deviceManagement) {
        //查询deviceCode是否存在，去重
        List<DeviceManagement> devicelist = deviceManagementMapper.querybyDeviceCode(deviceManagement.getDeviceCode(), "");
        if (devicelist != null && devicelist.size() > 0 && deviceManagement.getDeviceCode().equals(devicelist.get(0).getDeviceCode())) {
            return new BaseResult("300", "设备编号已存在");
        }
        deviceManagement.setId(UUIDUtils.getUUID("device"));
        deviceManagement.setCreateTime(new Date());
        BaseResult baseResult = deviceManagementService.insertDevice(deviceManagement);
        return baseResult;
    }

    /**
     * 删除设备信息
     * author:赵参谋
     *
     * @return
     */
    @RequestMapping("/deleteDevice")
    public BaseResult deleteDevice(String ids) {
        //判断是否启用
        List<Object> idlist = Arrays.asList(ids.split(","));
        for (Object id : idlist) {
            DeviceManagement deviceManagement = deviceManagementMapper.selectByPrimaryKey(id.toString());
            if (deviceManagement != null && !"equipment_state_0".equals(deviceManagement.getDeviceStatus())) {
                return new BaseResult<>("300", "设备已启用无法删除");
            }
            deviceManagementService.deleteDevice(id.toString());
        }
        return BaseResult.success("删除成功");
    }

    /**
     * 更新设备信息
     * author:赵参谋
     *
     * @param deviceManagement
     * @return
     */
    @RequestMapping("/updateDevice")
    public BaseResult updateDevice(DeviceManagement deviceManagement) {
        //判断是否启用：有维修记录
        DeviceManagement DeviceManagementList = deviceManagementMapper.selectByPrimaryKey(deviceManagement.getId());
        if (DeviceManagementList != null && !"equipment_state_0".equals(DeviceManagementList.getDeviceStatus()) && !deviceManagement.getDeviceCode().equals(DeviceManagementList.getDeviceCode())) {
            return new BaseResult<>("300", "该设备已启用，请勿更改设备编号！");
        }
        //查询deviceCode是否存在，去重
        List<DeviceManagement> devicelist = deviceManagementMapper.querybyDeviceCode(deviceManagement.getDeviceCode(), deviceManagement.getId());
        if (devicelist != null && devicelist.size() > 0 && deviceManagement.getDeviceCode().equals(devicelist.get(0).getDeviceCode())) {
            return new BaseResult<>("300", "设备编号已存在");
        }
        deviceManagement.setUpdateTime(new Date());
        BaseResult baseResult = deviceManagementService.updateDevice(deviceManagement);
        return baseResult;
    }

    /**
     * 插入维修信息
     * author:赵参谋
     *
     * @return
     */
    @RequestMapping("/insertRepair")
    public BaseResult insertRepairInfos(RepairRecord repaireRecord) {
        repaireRecord.setRepairDateStar(new Date());
        BaseResult result = deviceManagementService.insertReapirRecord(repaireRecord);
        if (repaireRecord.getRepairStatus().equals("repairStatus_02")) {
            deviceManagementMapper.updateDeviceStatus(repaireRecord.getRepairDeviceId(), "equipment_state_3");//修改设备状态‘维修中’
        }
        if (repaireRecord.getRepairStatus().equals("repairStatus_03")) {
            deviceManagementMapper.updateDeviceStatus(repaireRecord.getRepairDeviceId(), "equipment_state_1");//修改设备状态‘正常’
        }
        return result;
    }

    /**
     * 导出设备信息
     * author:赵参谋
     */
    @RequestMapping("/exporDeviceInfos")
    public void exporDeviceInfos(String serchnameParam, String searchNoParam, String serchStatusParam) {
        ExcelData excelData = this.exportRegisterOrgan(serchnameParam, searchNoParam, serchStatusParam);
        ExportExcelUtils.exportFile(this.getResponse(), excelData);
    }


    public ExcelData exportRegisterOrgan(String serchnameParam, String searchNoParam, String serchStatusParam) {
        try {
            ExcelData excelData = new ExcelData();
            excelData.setExcelName("采集设备管理数据");
            // 设置Sheet名称
            excelData.setSheetName("设备管理数据");
            // 设置表头
            String heads = "设备名称,设备编号,设备地址,设备经度,设备纬度,设备状态,设备描述信息,设备添加时间,设备更新时间";
            // 设置单元格宽度
            Map<Integer, Integer> widthAndHeiht = new HashMap<Integer, Integer>();
            widthAndHeiht.put(1, 4000);
            widthAndHeiht.put(2, 5000);
            widthAndHeiht.put(3, 5000);
            widthAndHeiht.put(4, 5000);
            widthAndHeiht.put(5, 5000);
            widthAndHeiht.put(6, 5000);
            widthAndHeiht.put(7, 5000);
            widthAndHeiht.put(8, 5000);
            widthAndHeiht.put(9, 5000);
            excelData.setWidthAndHeiht(widthAndHeiht);
            // 设置表格主内容
            List<DeviceManagement> deviceManagement = deviceManagementService.exportDeviceInfos(serchnameParam, searchNoParam, serchStatusParam);
            if (deviceManagement != null && deviceManagement.size() > 0) {
                List<String> data = new ArrayList<String>();
                StringBuffer row = new StringBuffer();
                SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                for (DeviceManagement device : deviceManagement) {
                    String deviceStatus = (String) redisUtil.get(device.getDeviceStatus());
                    row.append(device.getName()).append(",")
                            .append(device.getDeviceCode()).append(",")
                            .append(device.getDeviceAddress()).append(",")
                            .append(device.getDeviceGisX()).append(",")
                            .append(device.getDeviceGisY()).append(",")
                            .append(deviceStatus).append(",")
                            .append(device.getDescripInfos()).append(",")
                            .append(device.getCreateTime() != null ? dateFormate.format(device.getCreateTime()) : "").append(",")
                            .append(device.getUpdateTime() != null ? dateFormate.format(device.getUpdateTime()) : "");

                    data.add(row.toString());
                    row.delete(0, row.length());
                }
                excelData.setData(data);
            }

            excelData.setHeads(heads);
            return excelData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 获取维修记录信息
     * author:赵参谋
     *
     * @return
     */
    @RequestMapping("/getRepairRecord")
    public List<RepairRecord> getRepairRecord(String DeviceId) {
        List<RepairRecord> listRepairRecord = deviceManagementService.getRepairRecord(DeviceId);
        return listRepairRecord;
    }

    /**
     * 获取5.8g设备统计数据
     * (目前暂时没有搜索功能，所以这里可以不用管)
     *
     * @return
     */
    @RequestMapping("/deviceCount")
    public BaseResult getDeviceCount(String year) {
        return deviceManagementService.getDeviceCount(year);
    }


}
