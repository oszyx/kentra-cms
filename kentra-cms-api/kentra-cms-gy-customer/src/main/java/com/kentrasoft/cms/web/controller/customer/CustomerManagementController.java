package com.kentrasoft.cms.web.controller.customer;


import com.kentrasoft.cms.common.cache.util.RedisUtil;
import com.kentrasoft.cms.entity.Customer;
import com.kentrasoft.cms.service.CustomerService;
import com.kentrasoft.utils.exportExcel.ExportExcelUtils;
import com.kentrasoft.utils.exportExcel.bean.ExcelData;
import com.kentrasoft.utils.plugin.BaseController;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/management/customer/")
public class CustomerManagementController extends BaseController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 用户列表
     *
     * @param page
     * @return
     */
    @RequestMapping("getPageList")
    public PageForm<Customer> getPageList(PageForm<Customer> page,
                                          String customerStatus, String linkTelphone1, String name, String driveNum) {
        PageForm<Customer> pageForm = customerService.getPageList(page, customerStatus, linkTelphone1, name, driveNum);
        return pageForm;
    }

    /**
     * 描述：新增用户
     *
     * @param customer
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/add")
    @ResponseBody
    public BaseResult add(Customer customer) {
        return customerService.add(customer);
    }

    /**
     * 描述：修改用户信息
     *
     * @param customer
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/edit")
    @ResponseBody
    public BaseResult edit(Customer customer) {
        return customerService.edit(customer);
    }

    /**
     * 描述：删除用户
     *
     * @param ids
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/delete")
    @ResponseBody
    public BaseResult delete(String ids) {
        return customerService.delete(ids);
    }

    /**
     * 描述：修改用户状态
     *
     * @param ids, customerStatus
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/updateCustomerStatus")
    @ResponseBody
    public BaseResult updateCustomerStatus(String ids, String customerStatus) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("ids", ids);
        map.put("customerStatus", customerStatus);
        String status = customerService.updateCustomerStatus(map);
        if (!status.equals("200")) {
            return BaseResult.faild(status);
        }
        if (customerStatus.equals("customer_status_1"))
            return BaseResult.success("加入黑名单成功");
        else
            return BaseResult.success("加入白名单成功");
    }


    /**
     * 导出用户信息
     *
     * @param
     */
    @RequestMapping("/exportCustomerInfos")
    public void exportCustomerInfos(String code, String phoneNum, String name, String driveNum) throws Exception {
        ExcelData excelData = this.exportCustomer(code, phoneNum, name, driveNum);
        ExportExcelUtils.exportFile(this.getResponse(), excelData);
    }

    public ExcelData exportCustomer(String code, String phoneNum, String name, String driveNum) throws Exception {
        ExcelData excelData = new ExcelData();
        if (code.equals("customer_status_0")) {
            excelData.setExcelName("普通用户管理数据");
            // 设置Sheet名称
            excelData.setSheetName("普通用户管理数据");
        }
        if (code.equals("customer_status_1")) {
            excelData.setExcelName("黑名单用户管理数据");
            // 设置Sheet名称
            excelData.setSheetName("黑名单用户管理数据");
        }
        if (code.equals("customer_status_2")) {
            excelData.setExcelName("白名单用户管理数据");
            // 设置Sheet名称
            excelData.setSheetName("白名单用户管理数据");
        }
        // 设置表头
        String heads = "用户ID,姓名,性别,国籍,出生日期,证件类型,证件号码,手机,联系地址,驾驶证号码,准驾车型";
        // 设置单元格宽度
        Map<Integer, Integer> widthAndHeiht = new HashMap<Integer, Integer>();
        widthAndHeiht.put(1, 6000);
        widthAndHeiht.put(2, 6000);
        widthAndHeiht.put(3, 8000);
        widthAndHeiht.put(4, 8000);
        widthAndHeiht.put(5, 8000);
        widthAndHeiht.put(6, 8000);
        widthAndHeiht.put(7, 8000);
        widthAndHeiht.put(8, 8000);
        widthAndHeiht.put(9, 8000);
        widthAndHeiht.put(10, 8000);
        widthAndHeiht.put(11, 8000);
        excelData.setWidthAndHeiht(widthAndHeiht);
        // 设置表格主内容
        List<Customer> customerList = customerService.exportCustomerInfos(code, phoneNum, name, driveNum);
        if (customerList != null && customerList.size() > 0) {
            List<String> data = new ArrayList<String>();
            StringBuffer row = new StringBuffer();
            SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");
            for (Customer customer : customerList) {
                row.append(customer.getId()).append(",")
                        .append(customer.getName()).append(",")
                        .append(StringUtils.isBlank(customer.getSex()) ? "" : (String)redisUtil.get(customer.getSex())).append(",")
                        .append(StringUtils.isBlank(customer.getNational()) ? "" : (String)redisUtil.get(customer.getNational())).append(",")
                        .append(customer.getBirthday() != null ? dateFormate.format(customer.getBirthday()) : "").append(",")
                        .append(StringUtils.isBlank(customer.getDocumentType()) ? "" : (String)redisUtil.get(customer.getDocumentType())).append(",")
                        .append(customer.getDocumentNum()).append(",")
                        .append(customer.getLinkTelphone1()).append(",")
                        .append(customer.getLinkAddress()).append(",")
                        .append(customer.getDriveNum()).append(",")
                        .append(StringUtils.isBlank(customer.getDriveType()) ? "" : (String)redisUtil.get(customer.getDriveType()));

                data.add(row.toString());
                row.delete(0, row.length());
            }
            excelData.setData(data);
        }

        excelData.setHeads(heads);
        return excelData;
    }

    /**
     * 获取用户注册统计数据
     *
     * @param year 年代
     * @return
     */
    @RequestMapping("/customerCount")
    public BaseResult getCustomerCount(String year) {
        return customerService.getRegisterCustomerCount(year);
    }

}
