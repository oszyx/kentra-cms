package com.kentrasoft.cms.dao;

import com.kentrasoft.cms.entity.Customer;
import com.kentrasoft.cms.entity.CustomerExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component(value = "customerMapper")
public interface CustomerMapper {
    /**
     * @mbg.generated 2018-06-13
     */
    long countByExample(CustomerExample example);

    /**
     * @mbg.generated 2018-06-13
     */
    int deleteByExample(CustomerExample example);

    /**
     * @mbg.generated 2018-06-13
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @mbg.generated 2018-06-13
     */
    int insert(Customer record);

    /**
     * @mbg.generated 2018-06-13
     */
    int insertSelective(Customer record);

    /**
     * @mbg.generated 2018-06-13
     */
    List<Customer> selectByExample(CustomerExample example);

    /**
     * @mbg.generated 2018-06-13
     */
    Customer selectByPrimaryKey(Long id);

    /**
     * @mbg.generated 2018-06-13
     */
    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    /**
     * @mbg.generated 2018-06-13
     */
    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    /**
     * @mbg.generated 2018-06-13
     */
    int updateByPrimaryKeySelective(Customer record);

    /**
     * @mbg.generated 2018-06-13
     */
    int updateByPrimaryKey(Customer record);

    /**
     * 删除
     */
    void delete(String ids);

    /**
     * 修改用户状态
     */
    void updateCustomerStatus(Map<String, String> map);

    /**
     * 添加的时候查询是否存在录入信息的记录
     *
     * @param driveNum
     * @return
     */
    List<Customer> selectByDrivNum(String driveNum);

    /**
     * 添加的时候查询是否存在录入信息的记录
     *
     * @param documentNum
     * @return
     */
    List<Customer> selectByDocuNum(String documentNum);

    /**
     * 添加的时候查询是否已有用户绑定该电话号码
     *
     * @param phone
     * @return
     */
    List<Customer> selectByPhoneNum(String phone);

    /**
     * 编辑的时候查询是否存在录入信息的记录
     *
     * @param params
     * @return
     */
    List<Customer> selectByDocuNumEdit(Map<String, Object> params);

    /**
     * 编辑的时候查询是否存在录入信息的记录
     *
     * @param params
     * @return
     */
    List<Customer> selectByDrivNumEdit(Map<String, Object> params);

    /**
     * 导出居右索搜条件的数据
     *
     * @param params
     * @return
     */
    List<Customer> export(Map<String, Object> params);

    /**
     * 登陆时查询是否存在该用户
     *
     * @param params
     * @return
     */
    Customer selectByPhonePwd(Map<String, Object> params);

    /**
     * 修改密码
     *
     * @param params
     */
    void updatePwd(Map<String, Object> params);

    /**
     * 修改密码时验证密码是否正确
     *
     * @param params
     */
    Customer selectByIdPhone(Map<String, Object> params);

    /**
     * 根据手机号查询
     */
    List<Customer> selectByLinkPhone(Map<String, Object> params);

    /**
     * 根据年份查询用户注册数据统计 默认是当前年的注册信息
     *
     * @param params 年代
     * @return
     */
    List<Customer> getRegisterCustomerCount(Map<String, Object> params);

    /**
     * 查询准驾类型
     */
    String selectDrivingTypeCode(@Param("driveType") String driveType);

}