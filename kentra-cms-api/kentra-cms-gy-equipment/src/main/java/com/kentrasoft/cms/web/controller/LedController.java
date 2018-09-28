package com.kentrasoft.cms.web.controller;

import com.kentrasoft.cms.common.cache.util.RedisUtil;
import com.kentrasoft.cms.dao.LedManagementMapper;
import com.kentrasoft.cms.entity.LedManagement;
import com.kentrasoft.cms.entity.RepairRecord;
import com.kentrasoft.cms.service.LedService;
import com.kentrasoft.utils.exportExcel.ExportExcelUtils;
import com.kentrasoft.utils.exportExcel.bean.ExcelData;
import com.kentrasoft.utils.plugin.BaseController;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：led管理
 *
 * @author liyang
 * @date 2018年6月19日 11点05分
 */
@Controller
@RequestMapping(value = "/led")
public class LedController extends BaseController {

    @Autowired
    private LedService ledService;

    @Autowired
    private LedManagementMapper ledManagementMapper;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 描述：分页查询
     *
     * @param page
     * @return
     */
    @RequestMapping(value = "/getLedPage", method = RequestMethod.POST)
    @ResponseBody
    public PageForm<LedManagement> getPageList(PageForm<LedManagement> page, LedManagement ledManagement) {
        if (ledManagement.getName() != null) {
            page.setModel(ledManagement);
        }
        PageForm<LedManagement> pageForm = ledService.getLedPage(page);
        return pageForm;
    }

    /**
     * 描述：获取led详情
     *
     * @param ledManagement
     * @return
     */
    @RequestMapping(value = "/ledEdit")
    @ResponseBody
    public BaseResult ledEdit(LedManagement ledManagement) {
        return ledService.edit(ledManagement);
    }

    /**
     * 描述：led维护
     *
     * @param repairRecord
     * @return
     */
    @RequestMapping(value = "/ledRepair")
    @ResponseBody
    public BaseResult ledRepair(RepairRecord repairRecord) {
        return ledService.repair(repairRecord);
    }

    /**
     * 描述：删除led信息，PS:维修记录保留
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public BaseResult delete(String ids) {
        return ledService.delete(ids);
    }

    /**
     * 描述：添加led
     *
     * @param ledManagement
     * @return
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public BaseResult add(LedManagement ledManagement) throws ParseException {
        return ledService.add(ledManagement);
    }

    /**
     * 描述：导出excel
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/export")
    @ResponseBody
    public void export(HttpServletRequest request, HttpServletResponse response, String searchName,
                       String searchCode, String searchStatus) throws IOException {
        ExcelData excelData = this.exportRegisterOrgan(request, response, searchName, searchCode, searchStatus);
        ExportExcelUtils.exportFile(this.getResponse(), excelData);
    }

    /**
     * author:赵参谋
     *
     * @param request
     * @param response
     * @return
     */
    public ExcelData exportRegisterOrgan(HttpServletRequest request, HttpServletResponse response, String searchName, String searchCode, String searchStatus) {
        try {
            ExcelData excelData = new ExcelData();
            excelData.setExcelName("LED设备管理数据");
            // 设置Sheet名称
            excelData.setSheetName("LED管理数据");
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
            //数据
            List<LedManagement> ledList = this.getLedList(searchName, searchCode, searchStatus);

            if (ledList != null && ledList.size() > 0) {
                List<String> data = new ArrayList<String>();
                StringBuffer row = new StringBuffer();
                SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                for (LedManagement ledManagement : ledList) {
                    row.append(ledManagement.getName()).append(",")
                            .append(ledManagement.getLedCode() == null ? "" : ledManagement.getLedCode()).append(",")
                            .append(ledManagement.getLedAddress() == null ? "" : ledManagement.getLedAddress()).append(",")
                            .append(ledManagement.getLedGisX() == null ? "" : ledManagement.getLedGisX()).append(",")
                            .append(ledManagement.getLedGisY() == null ? "" : ledManagement.getLedGisY()).append(",")
                            .append((String) redisUtil.get(ledManagement.getLedStatus())).append(",")
                            .append(ledManagement.getDescripInfos() == null ? "" : ledManagement.getDescripInfos()).append(",")
                            .append(ledManagement.getCreateTime() == null ? "" : dateFormate.format(ledManagement.getCreateTime())).append(",")
                            .append(ledManagement.getUpdateTime() == null ? "" : dateFormate.format(ledManagement.getUpdateTime()));
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
     * 描述：获取led设备维修记录
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/getRepairRecord")
    @ResponseBody
    public List<RepairRecord> getRepairRecord(String ledId) {
        if (StringUtils.isNullOrEmpty(ledId)) {
            return null;
        }
        List<RepairRecord> repairRecordList = ledService.getRepairRecord(ledId);
        return repairRecordList;
    }

    public List<LedManagement> getLedList(String searchName, String searchCode, String searchStatus) {
        if (searchName != null && searchName != "" || searchCode != null && searchCode != "" || searchStatus != null && searchStatus != "") {
            List<LedManagement> ledManagementList = ledManagementMapper.selectLedListBySearch(searchName, searchCode, searchStatus);
            return ledManagementList;
        } else {
            List<LedManagement> ledManagementList = ledManagementMapper.selectLedList();
            return ledManagementList;
        }
    }
}
