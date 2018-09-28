package com.kentrasoft.cms.service.impl;

import com.kentrasoft.cms.dao.ControllerManagementMapper;
import com.kentrasoft.cms.dao.DeviceManagementMapper;
import com.kentrasoft.cms.dao.RepairRecordMapper;
import com.kentrasoft.cms.entity.*;
import com.kentrasoft.cms.service.DeviceManagementService;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@SuppressWarnings("rawtypes")
public class DeviceManagementServiceImpl implements DeviceManagementService {

    private static Logger log = Logger.getLogger(DeviceManagementServiceImpl.class);

    @Autowired
    private DeviceManagementMapper deviceManagementMapper;

    @Autowired
    private ControllerManagementMapper controllerManagementMapper;

    @Autowired
    private RepairRecordMapper repairRecordMapper;

    @Override
    public PageForm<DeviceManagement> getPageList(PageForm<DeviceManagement> page, String name, String searchNo, String serchStatus, String ids) {
        DeviceManagementExample deviceManagementExample = new DeviceManagementExample();
        DeviceManagementExample.Criteria criteria = deviceManagementExample.createCriteria();

        if (!"".equals(name) && null != name) {
            criteria.andNameLike("%" + name + "%");
        }
        if (!"".equals(searchNo) && null != searchNo) {
            criteria.andDeviceCodeLike("%" + searchNo + "%");
        }
        if (!"".equals(serchStatus) && null != serchStatus) {
            criteria.andDeviceStatusEqualTo(serchStatus);
        }
        if (!"".equals(ids) && null != ids && ids.contains(",")) {
            criteria.andIdIn(Arrays.asList(ids.split(",")));
        } else if (!"".equals(ids) && null != ids) {
            criteria.andIdEqualTo(ids);
        }

        //查询所有的数据数量
        long deviceManagementCount = deviceManagementMapper.countByExample(deviceManagementExample);

        //分页查询所有的数据
        deviceManagementExample.setLimitStart((page.getPage() - 1) * page.getLimit());
        deviceManagementExample.setLimitEnd(page.getLimit());
        List<DeviceManagement> deviceManagement = deviceManagementMapper.selectByExample(deviceManagementExample);

        //回写内容
        page.setCount((int) deviceManagementCount);
        page.setData(deviceManagement);
        return page;
    }

    @Override
    public List<ControllerManagement> getControllerList(String id) {
        ControllerManagementExample controllerManagementExample = new ControllerManagementExample();
        ControllerManagementExample.Criteria criteria = controllerManagementExample.createCriteria();
        if (!"".equals(id) && null != id) {
            criteria.andIdEqualTo(id);
        }

        List<ControllerManagement> controllerList = controllerManagementMapper.selectByExample(controllerManagementExample);
        return controllerList;
    }

    @Override
    public BaseResult insertDevice(DeviceManagement device) {
        BaseResult baseResult = new BaseResult<>();
        try {
            deviceManagementMapper.insert(device);
            baseResult.setMessage("新增成功");
            baseResult.setStatusCode("200");
            return baseResult;
        } catch (Exception e) {
            log.warn(e.getMessage());
            baseResult.setMessage("新增失败");
            baseResult.setStatusCode("300");
            return baseResult;
        }


    }

    @Override
    public BaseResult deleteDevice(String ids) {
        BaseResult baseResult = new BaseResult<>();
        try {
            DeviceManagementExample deviceManagementExample = new DeviceManagementExample();
            DeviceManagementExample.Criteria criteria = deviceManagementExample.createCriteria();
            if (ids.contains(",")) {
                criteria.andIdIn(Arrays.asList(ids.split(",")));
            } else {
                criteria.andIdEqualTo(ids);
            }
            deviceManagementMapper.deleteByExample(deviceManagementExample);
            baseResult.setMessage("删除成功");
            baseResult.setStatusCode("200");
            return baseResult;
        } catch (Exception e) {
            log.warn(e.getMessage());
            baseResult.setMessage("删除失败");
            baseResult.setStatusCode("400");
            return baseResult;
        }

    }

    @Override
    public BaseResult updateDevice(DeviceManagement device) {
        BaseResult baseResult = new BaseResult<>();
        try {
            deviceManagementMapper.updateByPrimaryKey(device);
            baseResult.setMessage("修改成功");
            baseResult.setStatusCode("200");
            return baseResult;
        } catch (Exception e) {
            log.warn(e.getMessage());
            baseResult.setMessage("修改失败");
            baseResult.setStatusCode("400");
            return baseResult;
        }
    }

    @Override
    public BaseResult insertReapirRecord(RepairRecord repaireRecord) {
        BaseResult baseResult = new BaseResult<>();
        try {
            repairRecordMapper.insert(repaireRecord);
            baseResult.setMessage("新增维修信息成功");
            baseResult.setStatusCode("200");
            return baseResult;
        } catch (Exception e) {
            log.warn(e.getMessage());
            baseResult.setMessage("新增维修信息失败");
            baseResult.setStatusCode("400");
            return baseResult;
        }
    }

    @Override
    public List<DeviceManagement> exportDeviceInfos(String serchnameParam, String searchNoParam, String serchStatusParam) {

        if (serchnameParam != null && serchnameParam != "" || searchNoParam != null && searchNoParam != "" || serchStatusParam != null && serchStatusParam != "") {
            List<DeviceManagement> deviceList = deviceManagementMapper.selectDeviceManagementBykey(serchnameParam, searchNoParam, serchStatusParam);
            return deviceList;
        } else {
            List<DeviceManagement> deviceList = deviceManagementMapper.selectDeviceManagement();
            return deviceList;
        }
    }

    @Override
    public List<RepairRecord> getRepairRecord(String DeviceId) {
        List<RepairRecord> listRepairRecord = deviceManagementMapper.selectRepairRecord(DeviceId);
        return listRepairRecord;
    }

    /**
     * 获取5.8g设备统计数据
     *
     * @param year 年代 (目前暂时没有搜索功能，所以这里可以不用管)
     * @return
     */
    @Override
    public BaseResult getDeviceCount(String year) {
        List<DeviceManagement> deviceCount = deviceManagementMapper.getDeviceCount(year);
        List<Integer> list = new ArrayList();
        if (deviceCount.size() > 0) {
            for (int i = 0; i < deviceCount.size(); i++) {
                list.add(deviceCount.get(i).getCountNum());
            }
            return BaseResult.success("获取统计数据成功", list);
        } else {
            return BaseResult.faild("获取统计数据失败");
        }
    }
}
