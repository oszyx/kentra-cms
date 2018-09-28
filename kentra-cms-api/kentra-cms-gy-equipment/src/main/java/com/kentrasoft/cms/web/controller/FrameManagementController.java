/**
 * 龙门架
 * author:赵参谋
 * Data:2018-6-21
 */
package com.kentrasoft.cms.web.controller;

import com.kentrasoft.cms.common.cache.util.RedisUtil;
import com.kentrasoft.cms.dao.FrameManagementMapper;
import com.kentrasoft.cms.dao.RepairRecordMapper;
import com.kentrasoft.cms.entity.DictInfos;
import com.kentrasoft.cms.entity.FrameManagement;
import com.kentrasoft.cms.entity.RepairRecord;
import com.kentrasoft.cms.service.DeviceManagementService;
import com.kentrasoft.utils.exportExcel.ExportExcelUtils;
import com.kentrasoft.utils.exportExcel.bean.ExcelData;
import com.kentrasoft.utils.plugin.BaseController;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import com.kentrasoft.utils.uuid.UUIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/frame")
public class FrameManagementController extends BaseController {

    private Logger log = LoggerFactory.getLogger(FrameManagementController.class);

    @Autowired
    private FrameManagementMapper frameManagementMapper;

    @Autowired
    private RepairRecordMapper repairRecordMapper;

    @Autowired
    private DeviceManagementService deviceManagementService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 加载龙门架信息
     * author:赵参谋
     *
     * @param page
     * @param
     * @return
     */
    @RequestMapping("/getPageList")
    public PageForm<FrameManagement> getPageList(PageForm<FrameManagement> page, String serchName, String searchNo, String serchStatus) {
        int limitStar = 0, limitEnd = 0;
        if (page.getLimit() != null && page.getPage() != null) {
            limitStar = (page.getPage() - 1) * page.getLimit();
            limitEnd = page.getPage() * page.getLimit();
        }
        int count = frameManagementMapper.QueryCount(serchName, searchNo, serchStatus);
        List<FrameManagement> data = frameManagementMapper.QuerypageForm(limitStar, limitEnd, serchName, searchNo, serchStatus);
        page.setCount(count);
        page.setData(data);
        return page;
    }

    /**
     * 获取设备状态信息
     * author:赵参谋
     *
     * @return
     */
    @RequestMapping("/getFrameStatus")
    public List<DictInfos> getStatus() {
        //获取数据字典设备状态
        List<DictInfos> frameStatus = frameManagementMapper.getDictFrameStatus("2");
        return frameStatus;
    }

    /**
     * 插入龙门架信息
     * author:赵参谋
     *
     * @param frameManagement
     * @return
     */
    @RequestMapping("/insertframe")
    public BaseResult<FrameManagement> insertframe(FrameManagement frameManagement) {
        BaseResult<FrameManagement> baseResult = new BaseResult<FrameManagement>();
        //判断是否存在
        List<FrameManagement> framelist = frameManagementMapper.querybyFrameCode(frameManagement.getFrameCode(), "");
        if (framelist != null && framelist.size() > 0 && frameManagement.getFrameCode().equals(framelist.get(0).getFrameCode())) {
            return new BaseResult<>("300", "设备编号已存在");
        }
        try {
            frameManagement.setId(UUIDUtils.getUUID("frame"));
            frameManagement.setCreateTime(new Date());
            frameManagementMapper.insert(frameManagement);
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

    /**
     * 删除数据
     * author:赵参谋
     *
     * @param ids
     * @return
     */
    @RequestMapping("/deleteFrame")
    public BaseResult<FrameManagement> deleteFrame(String ids) {
        BaseResult<FrameManagement> baseResult = new BaseResult<FrameManagement>();
        try {
            //判断是否启用
            List<Object> idlist = Arrays.asList(ids.split(","));
            for (Object id : idlist) {
                FrameManagement frameManagement = frameManagementMapper.selectByPrimaryKey(id.toString());
                if (frameManagement != null && !"equipment_state_0".equals(frameManagement.getFrameStatus())) {
                    return new BaseResult<>("300", "设备已启用无法删除");
                }
                frameManagementMapper.deleteByPrimaryKey(id.toString());
            }
            baseResult.setMessage("删除成功");
            baseResult.setStatusCode("200");
            return baseResult;
        } catch (Exception e) {
            log.warn(e.getMessage());
            baseResult.setMessage("删除失败");
            baseResult.setStatusCode("300");
            return baseResult;
        }

    }

    /**
     * 更新龙门架信息
     * author:赵参谋
     *
     * @return
     */
    @RequestMapping("/updateFrame")
    public BaseResult<FrameManagement> updateFrame(FrameManagement frameManagement) {
        BaseResult<FrameManagement> baseResult = new BaseResult<FrameManagement>();
        try {
            //判断是否启用
            FrameManagement frameManagementList = frameManagementMapper.selectByPrimaryKey(frameManagement.getId());
            if (frameManagementList != null && !"equipment_state_0".equals(frameManagementList.getFrameStatus())
                    && !frameManagement.getFrameCode().equals(frameManagementList.getFrameCode())) {
                return new BaseResult<>("300", "该设备已启用，请勿更改设备编号！");
            }
            //判断是否存在
            List<FrameManagement> framelist = frameManagementMapper.querybyFrameCode(frameManagement.getFrameCode(), frameManagement.getId());
            if (framelist != null && framelist.size() > 0 && frameManagement.getFrameCode().equals(framelist.get(0).getFrameCode())) {
                return new BaseResult<>("300", "设备编号已存在");
            }
            List<FrameManagement> data = frameManagementMapper.QueryCreatTime(frameManagement.getId());
            frameManagement.setCreateTime(data.get(0).getCreateTime());
            frameManagement.setUpdateTime(new Date());
            frameManagementMapper.updateByPrimaryKey(frameManagement);
            baseResult.setMessage("修改成功");
            baseResult.setStatusCode("200");
            return baseResult;
        } catch (Exception e) {
            log.warn(e.getMessage());
            baseResult.setMessage("删除失败");
            baseResult.setStatusCode("300");
            return baseResult;
        }
    }

    /**
     * 新增维修记录
     * author:赵参谋
     *
     * @return
     */
    @RequestMapping("/insertRepair")
    public BaseResult<FrameManagement> insertRepair(RepairRecord repaireRecord) {
        BaseResult<FrameManagement> baseResult = new BaseResult<FrameManagement>();
        try {
            //插入维修记录
            repairRecordMapper.insert(repaireRecord);

            baseResult.setMessage("新增维修记录成功");
            baseResult.setStatusCode("200");

//			if(repaireRecord.getRepairStatus().equals("repairStatus_02")){
//				frameManagementMapper.updateFrameStatus(repaireRecord.getRepairDeviceId(),"equipment_state_3");//修改设备状态‘维修中’
//	        	}
//	        if(repaireRecord.getRepairStatus().equals("repairStatus_03")){
//	        	frameManagementMapper.updateFrameStatus(repaireRecord.getRepairDeviceId(),"equipment_state_1");//修改设备状态‘正常’
//				}
            return baseResult;
        } catch (Exception e) {
            log.warn(e.getMessage());
            baseResult.setMessage("新增维修记录失败");
            baseResult.setStatusCode("400");
            return baseResult;
        }
    }

    /**
     * 导出龙门架数据信息
     * author:赵参谋
     */

    @RequestMapping("/exporFrameInfos")
    public void exporDeviceInfos(String serchnameParam, String searchNoParam, String serchStatusParam) {
        ExcelData excelData = this.exporFrameExcel(serchnameParam, searchNoParam, serchStatusParam);
        ExportExcelUtils.exportFile(this.getResponse(), excelData);
    }


    public ExcelData exporFrameExcel(String serchnameParam, String searchNoParam, String serchStatusParam) {
        try {
            ExcelData excelData = new ExcelData();
            excelData.setExcelName("龙门架设备数据");
            // 设置Sheet名称
            excelData.setSheetName("龙门架设备数据");
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
            List<FrameManagement> frameManagement = exportFrameManagement(serchnameParam, searchNoParam, serchStatusParam);
            if (frameManagement != null && frameManagement.size() > 0) {
                List<String> data = new ArrayList<String>();
                StringBuffer row = new StringBuffer();
                SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                for (FrameManagement frame : frameManagement) {
                    String frameStatus = (String) redisUtil.get(frame.getFrameStatus());
                    row.append(frame.getName()).append(",")
                            .append(frame.getFrameCode()).append(",")
                            .append(frame.getFrameAddress()).append(",")
                            .append(frame.getFrameGisX()).append(",")
                            .append(frame.getFrameGisY()).append(",")
                            .append(frameStatus).append(",")
                            .append(frame.getDescripInfos()).append(",")
                            .append(frame.getCreateTime() != null ? dateFormate.format(frame.getCreateTime()) : "").append(",")
                            .append(frame.getUpdateTime() != null ? dateFormate.format(frame.getUpdateTime()) : "");

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
     * 查询导出数据
     */
    public List<FrameManagement> exportFrameManagement(String serchnameParam, String searchNoParam, String serchStatusParam) {

        if (serchnameParam != null && serchnameParam != "" || searchNoParam != null && searchNoParam != "" || serchStatusParam != null && serchStatusParam != "") {
            List<FrameManagement> deviceList = frameManagementMapper.selectBykey(serchnameParam, searchNoParam, serchStatusParam);
            return deviceList;
        } else {
            List<FrameManagement> deviceList = frameManagementMapper.selectAll();
            return deviceList;
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

}
