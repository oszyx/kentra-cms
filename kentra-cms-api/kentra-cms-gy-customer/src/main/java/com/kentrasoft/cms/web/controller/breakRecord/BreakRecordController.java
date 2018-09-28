package com.kentrasoft.cms.web.controller.breakRecord;

import com.kentrasoft.cms.common.cache.util.RedisUtil;
import com.kentrasoft.cms.dao.DrivingRecordMapper;
import com.kentrasoft.cms.entity.BreakRecord;
import com.kentrasoft.cms.service.BreakRecordService;
import com.kentrasoft.utils.exportExcel.ExportExcelUtils;
import com.kentrasoft.utils.exportExcel.bean.ExcelData;
import com.kentrasoft.utils.plugin.BaseController;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/breakRecord")
public class BreakRecordController extends BaseController {

    @Autowired
    private BreakRecordService breakRecordService;

    @Autowired
    private DrivingRecordMapper drivingRecordMapper;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 描述：分页查询
     *
     * @param page
     * @return
     */
    @RequestMapping(value = "/getListPage")
    @ResponseBody
    public PageForm<BreakRecord> getPageList(PageForm<BreakRecord> page, String licenseNum, String remakeType, String searchBreakType) {
        PageForm<BreakRecord> pageForm = breakRecordService.getPageList(page, licenseNum, remakeType, searchBreakType);
        return pageForm;
    }

    /**
     * 描述：添加
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public BaseResult add(BreakRecord breakRecord) {
        return breakRecordService.add(breakRecord);
    }

    /**
     * 描述：删除
     *
     * @param ids
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public BaseResult delete(String ids) {
        return breakRecordService.delete(ids);
    }


    /**
     * 描述：修改
     *
     * @param
     */
    @RequestMapping(value = "/edit")
    @ResponseBody
    public BaseResult edit(BreakRecord breakRecord) {
        return breakRecordService.edit(breakRecord);
    }

    /**
     * 审核违规信息
     *
     * @param breakRecord
     * @return
     */
    @RequestMapping(value = "/examine")
    @ResponseBody
    public BaseResult examine(BreakRecord breakRecord) {
        return breakRecordService.examine(breakRecord);
    }

    /**
     * 描述:导出违规信息
     */
    @RequestMapping("/exportPayRecord")
    public void exportPayRecord(String searchLicenseNum, String searchAuditStatus,String searchRemakeType) throws Exception {
        ExcelData excelData = this.exportRegisterOrgan(searchLicenseNum, searchAuditStatus,searchRemakeType);
        ExportExcelUtils.exportFile(this.getResponse(), excelData);
    }

    public ExcelData exportRegisterOrgan(String searchLicenseNum, String searchAuditStatus, String searchRemakeType) throws Exception {
        ExcelData excelData = new ExcelData();
        excelData.setExcelName("违规信息数据");
        // 设置Sheet名称
        excelData.setSheetName("违规信息数据");
        // 设置表头
        String heads = "车牌号码,进站时间,出站时间,进站名称,出站名称,应缴费(元),已缴费(元),待缴费(元),违规类型,审核状态,违规备注";
        // 设置单元格宽度
        Map<Integer, Integer> widthAndHeiht = new HashMap<Integer, Integer>();
        widthAndHeiht.put(0, 4000);
        widthAndHeiht.put(1, 5000);
        widthAndHeiht.put(2, 5000);
        widthAndHeiht.put(3, 5000);
        widthAndHeiht.put(4, 5000);
        widthAndHeiht.put(5, 5000);
        widthAndHeiht.put(6, 5000);
        widthAndHeiht.put(7, 5000);
        widthAndHeiht.put(8, 5000);
        widthAndHeiht.put(9, 5000);
        widthAndHeiht.put(10, 5000);
        excelData.setWidthAndHeiht(widthAndHeiht);
        // 设置表格主内容
        List<BreakRecord> payRecords = breakRecordService.exportBreakRecord(searchLicenseNum, searchAuditStatus,searchRemakeType);
        if (payRecords != null && payRecords.size() > 0) {
            List<String> data = new ArrayList<String>();
            StringBuffer row = new StringBuffer();
            SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            for (BreakRecord payRecord : payRecords) {
                //违规类型
                String remakeTypeName = (String) redisUtil.get(payRecord.getRemakeType());
                String auditStatus = "";
                if (payRecord.getAuditStatus().equals("break_underview_01")) {
                	auditStatus = "审核中";
				}
				if (payRecord.getAuditStatus().equals("break_underview_02")) {
					auditStatus = "审核通过";			
				}
				if (payRecord.getAuditStatus().equals("break_underview_03")) {
					auditStatus = "审核不通过";
				}
                row.append(payRecord.getLicenseNum()).append(",")
                        .append(payRecord.getEntranceTime() == null ? "" : dateFormate.format(payRecord.getEntranceTime())).append(",")
                        .append(payRecord.getExitTime() == null ? "" : dateFormate.format(payRecord.getExitTime())).append(",")
                        .append(payRecord.getEntranceName() == null ? "" : payRecord.getEntranceName()).append(",")
                        .append(payRecord.getExitName() == null ? "" : payRecord.getExitName()).append(",")
                        .append(payRecord.getExtends1() == null ? "" : payRecord.getExtends1()).append(",")
                        .append(payRecord.getExtends2() == null ? "" : payRecord.getExtends2()).append(",")
                        .append(payRecord.getPayMoney() == null ? "" : payRecord.getPayMoney()).append(",")
                        .append(remakeTypeName).append(",")
                        .append(auditStatus).append(",")
                        .append(payRecord.getRemakeContent() == null ? "" : payRecord.getRemakeContent()).append(",");
                data.add(row.toString());
                row.delete(0, row.length());
            }
            excelData.setData(data);
        }

        excelData.setHeads(heads);
        return excelData;
    }

    /**
     * 描述：违规统计
     *
     * @param year
     */
    @RequestMapping(value = "/breakCount")
    @ResponseBody
    public BaseResult breakCount(String year) {
        BaseResult baseResult = breakRecordService.breakCount(year);
        return baseResult;
    }
}
