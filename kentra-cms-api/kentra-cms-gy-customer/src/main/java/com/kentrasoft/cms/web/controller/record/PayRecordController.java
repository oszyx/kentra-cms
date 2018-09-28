package com.kentrasoft.cms.web.controller.record;

import com.kentrasoft.cms.common.cache.util.RedisUtil;
import com.kentrasoft.cms.entity.PayRecord;
import com.kentrasoft.cms.service.PayRecordService;
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
import java.util.*;

/**
 * 缴费记录（增删改查）
 *
 * @author jiaming
 */
@Controller
@RequestMapping(value = "/record")
public class PayRecordController extends BaseController {

    @Autowired
    private PayRecordService payRecordService;
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
    public PageForm<PayRecord> getPageList(PageForm<PayRecord> page, String licenseNum, String payStatus, String isPay) {
        PageForm<PayRecord> pageForm = payRecordService.getPageList(page, licenseNum,payStatus,isPay);
        return pageForm;
    }

    /**
     * 描述：添加缴费记录
     *
     * @param payRecord
     * @return
     */
    @RequestMapping(value = "/goAdd")
    @ResponseBody
    public BaseResult add(PayRecord payRecord) {
        try {
        	double receivables = Double.parseDouble(payRecord.getReceivablesstr());
        	double payCount = Double.parseDouble(payRecord.getPayCountstr());
        	double expensesPaid = receivables - payCount;
        	expensesPaid = (double)Math.round(expensesPaid*100)/100;
        	payRecord.setPayCount(payCount);
            payRecord.setReceivables(receivables);
        	payRecord.setExpensesPaid(expensesPaid);//待缴费
        	payRecord.setPayTime(new Date());
        payRecordService.add(payRecord);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return BaseResult.success("添加成功");
    }

    /**
     * 描述：删除缴费记录
     *
     * @param ids
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public BaseResult delete(String ids) {
        String status = payRecordService.delete(ids);
        if (!status.equals("200")) {
            return BaseResult.faild(status);
        }
        return BaseResult.success("删除成功");
    }


    /**
     * 描述：修改缴费记录
     *
     * @param payRecord
     */
    @RequestMapping(value = "/goEdit")
    @ResponseBody
    public BaseResult edit(PayRecord payRecord) {
        try {
        	double receivables = Double.parseDouble(payRecord.getReceivablesstr());
        	double payCount = Double.parseDouble(payRecord.getPayCountstr());
        	double expensesPaid = receivables - payCount;
        	expensesPaid = (double)Math.round(expensesPaid*100)/100;
            payRecord.setPayCount(payCount);
            payRecord.setReceivables(receivables);
        	payRecord.setExpensesPaid(expensesPaid);//待缴费
            payRecordService.edit(payRecord);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return BaseResult.success("修改成功！");
    }

    /**
     * 描述:导出缴费记录信息
     */
    @RequestMapping("/exportPayRecord")
    public void exportPayRecord(String licenseNumParam,String PayStatusParam,String IsPayParam) {
        ExcelData excelData = this.exportRegisterOrgan(licenseNumParam,PayStatusParam,IsPayParam);
        ExportExcelUtils.exportFile(this.getResponse(), excelData);
    }


    public ExcelData exportRegisterOrgan(String licenseNumParam, String PayStatusParam, String IsPayParam) {
        try{
    	ExcelData excelData = new ExcelData();
        excelData.setExcelName("缴费记录数据");
        // 设置Sheet名称
        excelData.setSheetName("缴费记录数据");
        // 设置表头
        String heads = "车牌号码,进站名称,进站时间,出站名称,出站时间,缴费类型,应缴费用(元),已缴费用(元),待缴费用(元),缴费状态";
        // 设置单元格宽度
        Map<Integer, Integer> widthAndHeiht = new HashMap<Integer, Integer>();
        widthAndHeiht.put(0, 3800);
        widthAndHeiht.put(1, 4000);
        widthAndHeiht.put(2, 5300);
        widthAndHeiht.put(3, 4000);
        widthAndHeiht.put(4, 5300);
        widthAndHeiht.put(5, 4000);
        widthAndHeiht.put(6, 4000);
        widthAndHeiht.put(7, 4000);
        widthAndHeiht.put(8, 4000);
        widthAndHeiht.put(9, 4000);
        excelData.setWidthAndHeiht(widthAndHeiht);
        // 设置表格主内容
        List<PayRecord> payRecords = payRecordService.exportPayRecord(licenseNumParam,PayStatusParam,IsPayParam);
        if (payRecords != null && payRecords.size() > 0) {
            List<String> data = new ArrayList<String>();
            StringBuffer row = new StringBuffer();
            SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            for (PayRecord payRecord : payRecords) {
                String payStatus = (String) redisUtil.get(payRecord.getPayStatus());
                String isPay = (String) redisUtil.get(payRecord.getIsPay());
                row.append(payRecord.getLicenseNum()).append(",")
                        .append(payRecord.getEntranceName()).append(",")
                        .append(payRecord.getEntranceTime()  != null ? dateFormate.format(payRecord.getEntranceTime()) : "").append(",")
                        .append(payRecord.getExitName()).append(",")
                        .append(payRecord.getExitTime()  != null ? dateFormate.format(payRecord.getExitTime()) : "").append(",")
                        .append(payStatus).append(",")
                        .append(payRecord.getReceivables()).append(",")
                        .append(payRecord.getPayCount()).append(",")
                        .append(payRecord.getExpensesPaid()).append(",")
                        .append(isPay).append(",");
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

    /*******************************数据接口START*******************************/

    /**
     * 描述：查询当前用户车辆的缴费记录
     *
     * @param licenseNum 车牌号
     * @param customerId 客户ID
     * @param isPay 缴费状态
     * @return
     */
    @RequestMapping("/findDrivingPayment")
    @ResponseBody
    public BaseResult findDrivingPayment(String licenseNum, String customerId, String isPay ) {
        if (customerId == ""||customerId==null) {
           return BaseResult.faild("客户信息异常");
        }
        if (licenseNum == ""||licenseNum==null) {
            return BaseResult.faild("车辆信息异常");
        }
        Map<String,Object> queryData = new HashMap();
        queryData.put("customerId", customerId);
        queryData.put("licenseNum", licenseNum);
        queryData.put("isPay", isPay);
        BaseResult baseResult = payRecordService.findDrivingPayment(queryData);
        return baseResult;
    }

    /*******************************数据接口END*******************************/
}
