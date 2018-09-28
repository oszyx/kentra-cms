package com.kentrasoft.cms.service;

import com.kentrasoft.cms.entity.Customer;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;

import java.util.List;
import java.util.Map;

/**
 * 描述：客户service接口
 *
 * @author lihr
 * @date 2018/6/13
 */
public interface CustomerService {

    /**
     * 描述：条件分页查询
     *
     * @param page
     * @return
     */
    PageForm<Customer> getPageList(PageForm<Customer> page, String customerStatus, String linkTelphone1, String name, String driveNum);

    /**
     * 描述：新增客户
     *
     * @param customer
     */
    BaseResult add(Customer customer);

    /**
     * 描述：根据Id查找客户
     *
     * @param id
     * @return
     */
    Customer findById(Long id);

    /**
     * 描述：修改客户信息
     *
     * @param customer
     */
    BaseResult edit(Customer customer);

    /**
     * 描述：删除客户
     *
     * @param ids
     */
    BaseResult delete(String ids);

    /**
     * 描述：用户登录
     *
     * @param phone
     * @param password
     * @return
     */
    BaseResult login(String phone, String password);

    /**
     * 描述：修改用户状态
     *
     * @param map
     * @return
     */
    String updateCustomerStatus(Map<String, String> map);

    /**
     * 导出用户信息
     *
     * @return
     */
    List<Customer> exportCustomerInfos(String code, String phoneNum, String name, String driveNum);

    /**
     * 修改密码
     *
     * @param params
     * @return
     */
    BaseResult updatePwd(Map<String, Object> params);

    /**
     * 修改密码时验证旧密码是否正确
     *
     * @param params
     * @return
     */
    Customer selectByIdPhone(Map<String, Object> params);

    /**
     * 根据年份查询用户注册数据统计 默认是当前年的注册信息
     *
     * @param year 年代
     * @return
     */
    BaseResult getRegisterCustomerCount(String year);
}
