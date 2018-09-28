package com.kentrasoft.cms.service.impl;

import com.kentrasoft.cms.dao.LedManagementMapper;
import com.kentrasoft.cms.dao.RepairRecordMapper;
import com.kentrasoft.cms.entity.LedManagement;
import com.kentrasoft.cms.entity.RepairRecord;
import com.kentrasoft.cms.service.LedService;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import com.mysql.jdbc.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 描述：LED管理服务实现
 *
 * @author liyang
 * @date 2018年6月19日 16点40分
 */
@Service
public class LedServiceImpl implements LedService {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Autowired
    private LedManagementMapper ledManagementMapper;
    @Autowired
    private RepairRecordMapper repairRecordMapper;

    /**
     * 获取led列表信息o
     *
     * @param page
     * @return
     */
    @Override
    public PageForm<LedManagement> getLedPage(PageForm<LedManagement> page) {
        List<LedManagement> ledManagementList = ledManagementMapper.selectByExample(page);
        page.setData(ledManagementList);
        page.setCount(ledManagementList.size());
        return page;
    }

    /**
     * 编辑led信息
     *
     * @param ledManagement
     * @return
     */
    @Override
    public BaseResult edit(LedManagement ledManagement) {
        String ledCode = ledManagement.getLedCode();
        String id = ledManagement.getId();
        Map<String, Object> params = new HashMap<>();
        params.put("ledCode", ledCode);
        params.put("id", id);
        LedManagement led = ledManagementMapper.selectByLedCodeId(params);
        if (led != null) {
            return BaseResult.faild("设备编号已存在");
        }
        ledManagementMapper.updateByExampleSelective(ledManagement);
        return BaseResult.success("修改成功");
    }

    /**
     * 删除led信息，PS：维修记录应该保留
     *
     * @param ids
     * @return
     */
    @Override
    public BaseResult delete(String ids) {
        try {
            if (!StringUtils.isNullOrEmpty(ids)) {
                List<String> idList = Arrays.asList(ids.split(","));
                Map<String, Object> params = new HashMap<>();
                params.put("idList", idList);
                //删除维修记录
                repairRecordMapper.deleteByIds(params);
                //删除设备信息
                ledManagementMapper.deleteByIds(params);
                return BaseResult.success("删除成功");
            } else {
                return BaseResult.faild("传入数据错误");
            }
        } catch (Exception e) {
            return BaseResult.faild("删除失败：" + e.getMessage());
        }
    }

    /**
     * 添加led信息
     *
     * @param ledManagement 添加led信息体
     * @return
     */
    @Override
    public BaseResult add(LedManagement ledManagement) throws ParseException {
        LedManagement ledManagement1 = ledManagementMapper.selectByLedCode(ledManagement.getLedCode());
        if (ledManagement1 != null) {
            return BaseResult.faild("设备编号已存在");
        }
        System.out.println("--------------------------");
        Date date = new Date();
        long time = date.getTime() + 8 * 60 * 60 * 1000;
        ledManagement.setCreateTime(sdf.parse(sdf.format(time)));
        ledManagementMapper.insert(ledManagement);
        return BaseResult.success("新增成功");
    }

    /**
     * 导出excel功能
     *
     * @param request
     * @param response
     * @param name     查询参数
     * @throws IOException
     */
    @Override
    public void export(HttpServletRequest request, HttpServletResponse response, String name, String code, String status) throws IOException {
        //在sheet里创建第三行
        PageForm pageForm = new PageForm();
        pageForm.setLimit(Integer.MAX_VALUE);
        pageForm.setPage(1);
        LedManagement model = new LedManagement();
        if (!StringUtils.isNullOrEmpty(name)) {
            model.setName(name);
        }
        if (!StringUtils.isNullOrEmpty(code)) {
            model.setLedCode(code);
        }
        if (!StringUtils.isNullOrEmpty(status)) {
            model.setLedStatus(status);
        }
        pageForm.setModel(model);
        PageForm<LedManagement> ledPage = getLedPage(pageForm);
        List<LedManagement> ledList = ledPage.getData();
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet("LED设备管理信息表.xls");
        //设置列宽
        sheet.setColumnWidth(0, 4100);
        sheet.setColumnWidth(1, 4100);
        sheet.setColumnWidth(2, 4100);
        sheet.setColumnWidth(3, 4100);
        sheet.setColumnWidth(4, 4100);
        sheet.setColumnWidth(5, 4100);
        sheet.setColumnWidth(6, 8000);
        sheet.setColumnWidth(7, 6000);
        //设置居中
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
        HSSFFont font = wb.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        cellStyle.setFont(font);

        HSSFCellStyle colStyle = wb.createCellStyle();
        colStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
        colStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中

        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));
        HSSFRow row1 = sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell = row1.createCell(0);
        //设置单元格内容
        cell.setCellValue("LED设备信息");
        cell.setCellStyle(cellStyle);
        //在sheet里创建第二行
        HSSFRow row2 = sheet.createRow(1);
        //创建单元格并设置单元格内容
        HSSFCell cell1 = row2.createCell(0);
        cell1.setCellValue("设备名称");
        cell1.setCellStyle(cellStyle);
        cell1 = row2.createCell(1);
        cell1.setCellValue("设备编号");
        cell1.setCellStyle(cellStyle);
        cell1 = row2.createCell(2);
        cell1.setCellValue("设备地址");
        cell1.setCellStyle(cellStyle);
        cell1 = row2.createCell(3);
        cell1.setCellValue("设备经度");
        cell1.setCellStyle(cellStyle);
        cell1 = row2.createCell(4);
        cell1.setCellValue("设备纬度");
        cell1.setCellStyle(cellStyle);
        cell1 = row2.createCell(5);
        cell1.setCellValue("设备状态");
        cell1.setCellStyle(cellStyle);
        cell1 = row2.createCell(6);
        cell1.setCellValue("设备描述");
        cell1.setCellStyle(cellStyle);
        cell1 = row2.createCell(7);
        cell1.setCellValue("创建时间");
        cell1.setCellStyle(cellStyle);

        for (int i = 0; i < ledList.size(); i++) {
            LedManagement ledManagement = ledList.get(i);
            HSSFRow row = sheet.createRow(i + 2);
            HSSFCell cell2 = row.createCell(0);
            cell2.setCellValue(StringUtils.isNullOrEmpty(ledManagement.getName()) ? "" : ledManagement.getName());
            cell2.setCellStyle(colStyle);

            cell2 = row.createCell(1);
            cell2.setCellValue(StringUtils.isNullOrEmpty(ledManagement.getName()) ? "" : ledManagement.getLedCode());
            cell2.setCellStyle(colStyle);

            cell2 = row.createCell(2);
            cell2.setCellValue(StringUtils.isNullOrEmpty(ledManagement.getLedAddress()) ? "" : ledManagement.getLedAddress());
            cell2.setCellStyle(colStyle);

            cell2 = row.createCell(3);
            cell2.setCellValue(StringUtils.isNullOrEmpty(ledManagement.getLedGisX()) ? "" : ledManagement.getLedGisX());
            cell2.setCellStyle(colStyle);

            cell2 = row.createCell(4);
            cell2.setCellValue(StringUtils.isNullOrEmpty(ledManagement.getLedGisY()) ? "" : ledManagement.getLedGisY());
            cell2.setCellStyle(colStyle);

            cell2 = row.createCell(5);

            if (!StringUtils.isNullOrEmpty(ledManagement.getLedStatus()) && ledManagement.getLedStatus().equals("equipment_state_0")) {
                cell2.setCellValue("未启用");
            }
            if (!StringUtils.isNullOrEmpty(ledManagement.getLedStatus()) && ledManagement.getLedStatus().equals("equipment_state_1")) {
                cell2.setCellValue("正常");
            }
            if (!StringUtils.isNullOrEmpty(ledManagement.getLedStatus()) && ledManagement.getLedStatus().equals("equipment_state_2")) {
                cell2.setCellValue("故障");
            }
            if (!StringUtils.isNullOrEmpty(ledManagement.getLedStatus()) && ledManagement.getLedStatus().equals("equipment_state_3")) {
                cell2.setCellValue("维修中");
            }
            cell2.setCellStyle(colStyle);

            cell2 = row.createCell(6);
            cell2.setCellValue(StringUtils.isNullOrEmpty(ledManagement.getDescripInfos()) ? "" : ledManagement.getDescripInfos());
            cell2.setCellStyle(colStyle);

            cell2 = row.createCell(7);
            cell2.setCellValue(ledManagement.getCreateTime() == null ? "" : sdf.format(ledManagement.getCreateTime()));
            cell2.setCellStyle(colStyle);
        }
        //输出Excel文件
        OutputStream output = response.getOutputStream();
        String fileName = "LED设备管理信息表";
        response.reset();
        response.setHeader("Content-Disposition", "attachment;filename="
                + new String(fileName.getBytes(), "iso-8859-1") + ".xls");
        response.setContentType("application/msexcel;charset=UTF-8");
        wb.write(output);
        output.close();
    }

    /**
     * 设备维护
     *
     * @param repairRecord
     * @return
     */
    @Override
    public BaseResult repair(RepairRecord repairRecord) {
        repairRecordMapper.insertSelective(repairRecord);
        return BaseResult.success("新增维修记录成功!");
    }

    /**
     * 根据led的id获取维修记录
     *
     * @param ledId led设备id
     * @return
     */
    @Override
    public List<RepairRecord> getRepairRecord(String ledId) {
        return repairRecordMapper.selectByLedId(ledId);
    }
}
