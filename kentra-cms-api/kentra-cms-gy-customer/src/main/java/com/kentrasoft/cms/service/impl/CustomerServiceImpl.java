package com.kentrasoft.cms.service.impl;

import com.kentrasoft.cms.common.cache.util.RedisUtil;
import com.kentrasoft.cms.dao.CustomerMapper;
import com.kentrasoft.cms.dao.DrivingLicenseMapper;
import com.kentrasoft.cms.entity.Customer;
import com.kentrasoft.cms.entity.CustomerExample;
import com.kentrasoft.cms.entity.CustomerExample.Criteria;
import com.kentrasoft.cms.service.CustomerService;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import com.kentrasoft.utils.tools.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 描述：客户service实现
 *
 * @author lihr
 * @date 2018/6/13
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private DrivingLicenseMapper drivingLicenseMapper;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 描述：条件分页查询
     *
     * @param page
     * @return
     */
    @Override
    public PageForm<Customer> getPageList(PageForm<Customer> page,
                                          String customerStatus, String linkTelphone1, String name, String driveNum) {

        CustomerExample customerExample = new CustomerExample();
        Criteria crit = customerExample.createCriteria();

        //条件查询
        crit.andCustomerStatusEqualTo(customerStatus);
        if (linkTelphone1 != null && linkTelphone1 != "") {
            crit.andLinkTelphone1Like("%" + linkTelphone1 + "%");
        }
        if (name != null && name != "") {
            crit.andNameLike("%" + name + "%");
        }
        if (driveNum != null && driveNum != "") {
            crit.andDriveNumLike("%" + driveNum + "%");
        }

        //查询所有的数据数量
        long customertCount = customerMapper.countByExample(customerExample);

        //分页查询所有的数据
        customerExample.setLimitStart((page.getPage() - 1) * page.getLimit());
        customerExample.setLimitEnd(page.getLimit());

        List<Customer> customers = customerMapper.selectByExample(customerExample);

        //回写内容
        page.setCount((int) customertCount);
        page.setData(customers);

        return page;
    }

    /**
     * 描述：新增客户
     *
     * @param customer
     */
    @Override
    public BaseResult add(Customer customer) {
        //驾驶证号
        String driveNum = customer.getDriveNum();
        //证件号
        String documentNum = customer.getDocumentNum();
        //电话号码
        String phone = customer.getLinkTelphone1();
        List<Customer> list = customerMapper.selectByPhoneNum(phone);
        if (list.size() > 0) {
            return BaseResult.faild("该电话号已存在，请重试！");
        }
        List<Customer> customerList = customerMapper.selectByDocuNum(documentNum);
        if (customerList.size() > 0) {
            return BaseResult.faild("该身份证已存在，请重试！");
        }
        List<Customer> customers = customerMapper.selectByDrivNum(driveNum);
        if (customers.size() > 0) {
            return BaseResult.faild("该驾驶证号已存在，请重试！");
        }
        customer.setCreateTime(new Date());
        customer.setCustomerStatus("customer_status_0");
        customerMapper.insertSelective(customer);
        return BaseResult.success("新增成功!");
    }

    /**
     * 描述：根据Id查找客户
     *
     * @param id
     * @return
     */
    @Override
    public Customer findById(Long id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    /**
     * 描述：修改客户信息
     *
     * @param customer
     */
    @Override
    public BaseResult edit(Customer customer) {
        //客户id
        Long id = customer.getId();
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        //手机号
        String telPhone = customer.getLinkTelphone1();
        params.put("telPhone", telPhone);
        List<Customer> customersTel = customerMapper.selectByLinkPhone(params);
        if (customersTel != null && customersTel.size() > 0) {
            return BaseResult.faild("该电话号已存在，请重试！");
        }
        //证件号
        String documentNum = customer.getDocumentNum();
        params.put("docNum", documentNum);
        List<Customer> customers = customerMapper.selectByDocuNumEdit(params);
        if (customers.size() > 0) {
            return BaseResult.faild("该身份证信息已存在，请重试！");
        }
        //当证件号码不为空 并且 驾驶证号码不为空时  判断 证件号码与驾驶证号码是否一致  不一致则返回
        if (StringUtils.isNotEmpty(customer.getDocumentNum()) && StringUtils.isNotEmpty(customer.getDriveNum())) {
            if (!customer.getDocumentNum().equals(customer.getDriveNum())) {
                return BaseResult.faild("驾驶证号码须与身份证号码保持一致!");
            }
        }
        //匹配出生日期
        if (StringUtils.isNotBlank(documentNum)) {
            Map<String, String> map = this.getBirAgeSex(documentNum);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                customer.setBirthday(sdf.parse(map.get("birthday")));
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
//            customer.setSex(map.get("sexCode"));
            customer.setDocumentType("document_type_0");//身份证
        }
        //驾驶证号
        String driveNum = customer.getDriveNum();
        params.put("driNum", driveNum);
        List<Customer> customerList = customerMapper.selectByDrivNumEdit(params);
        if (customerList.size() > 0) {
            return BaseResult.faild("该驾驶证号信息已存在，请重试！");
        }
        customer.setUpdateTime(new Date());

        //准假车型
        String driveType = customer.getDriveType();
        if (StringUtils.isNotBlank(driveType)) {
            //查询车型key
            driveType.toUpperCase();
            if (redisUtil.get(driveType) == null || "".equals(driveType)) {
                String driveTypeCode = customerMapper.selectDrivingTypeCode(driveType);
                customer.setDriveType(driveTypeCode == null ? "" : driveTypeCode);
            }
        }
        //密码加密
        String password = customer.getPassword();
        if (!StringUtils.isBlank(password)) {
            customer.setPassword(MD5Util.string2MD5(password));
        }

        customerMapper.updateByPrimaryKeySelective(customer);
        return BaseResult.success("编辑成功");
    }

    /**
     * 描述：批量删除
     *
     * @param ids
     */
    @Override
    public BaseResult delete(String ids) {
        try {
            drivingLicenseMapper.deleteByCustomerIds(ids);
            customerMapper.delete(ids);
            return BaseResult.success("删除成功.");
        } catch (Exception e) {
            return BaseResult.faild("删除失败：" + e.getMessage());
        }
    }

    /**
     * 描述：用户登录
     *
     * @param phone
     * @return
     */
    @Override
    public BaseResult login(String phone, String password) {

        if (!StringUtils.isBlank(password)) {
            Map<String, Object> params = new HashMap<>();
            params.put("phone", phone);
            //账号密码登陆方式时判断此电话号码是否注册
            List<Customer> customerList = customerMapper.selectByPhoneNum(phone);
            if (customerList.size() < 1) {
                return BaseResult.faild("该用户不存在，请注册!");
            }
            params.put("password", MD5Util.string2MD5(password));
            Customer customer = customerMapper.selectByPhonePwd(params);
            if (customer == null) {
                return BaseResult.faild("密码错误，请输入正确密码!");
            } else {
                customer.setDriveType((String) redisUtil.get(customer.getDriveType()));
                return BaseResult.success("登录成功!", customer);
            }
        }
        List<Customer> customerList = null;
        if (StringUtils.isBlank(password)) {
            CustomerExample customerExample = new CustomerExample();
            Criteria crit = customerExample.createCriteria();
            crit.andLinkTelphone1EqualTo(phone);
            customerList = customerMapper.selectByExample(customerExample);
        }
        if (customerList.size() > 0) {
            Customer customer = customerList.get(0);
            customer.setDriveType((String) redisUtil.get(customer.getDriveType()));
            return BaseResult.success("登陆成功", customer);
        } else {
            Customer customer = new Customer();
            customer.setCustomerStatus("customer_status_0");
            customer.setLinkTelphone1(phone);
            customer.setCreateTime(new Date());
            customerMapper.insert(customer);
            customer.setId(customer.getId());
            return BaseResult.success("登录成功!", customer);
        }
    }

    /**
     * 描述：修改用户状态
     *
     * @param map
     */
    @Override
    public String updateCustomerStatus(Map<String, String> map) {
        try {
            customerMapper.updateCustomerStatus(map);
            return "200";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public List<Customer> exportCustomerInfos(String code, String phoneNum, String name, String driveNum) {
        Map<String, Object> params = new HashMap<>();
        params.put("flag", "0");
        params.put("code", code);
        if (StringUtils.isNotBlank(phoneNum)) {
            params.put("flag", "1");
            params.put("phoneNum", phoneNum);
        }
        if (StringUtils.isNotBlank(driveNum)) {
            params.put("flag", "1");
            params.put("driveNum", driveNum);
        }
        if (StringUtils.isNotBlank(name)) {
            params.put("flag", "1");
            params.put("name", name);
        }
        return customerMapper.export(params);
    }


    /**
     * 修改密码
     *
     * @param params
     * @return
     */
    @Override
    public BaseResult updatePwd(Map<String, Object> params) {
        customerMapper.updatePwd(params);
        return BaseResult.success("修改成功！");
    }

    /**
     * 修改密码时验证密码是否正确
     *
     * @param params
     * @return
     */
    @Override
    public Customer selectByIdPhone(Map<String, Object> params) {
        return customerMapper.selectByIdPhone(params);
    }

    /**
     * 根据年份查询用户注册数据统计 默认是当前年的注册信息
     *
     * @param year 年代
     * @return
     */
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

    @Override
    public BaseResult getRegisterCustomerCount(String year) {
        Map<String, Object> params = new HashMap<>();
        if (StringUtils.isBlank(year)) {
            params.put("year", sdf.format(new Date()));
        } else {
            params.put("year", year);
        }
        List<Customer> count = customerMapper.getRegisterCustomerCount(params);
        if (count.size() > 0) {
            List<Integer> countList = new ArrayList<>();
            for (int i = 0; i < count.size(); i++) {
                countList.add(count.get(i).getTotalNum());
            }
            return BaseResult.success("获取统计数据成功", countList);
        } else {
            return BaseResult.faild("获取统计数据失败");
        }
    }

    /**
     * 通过身份证号码获取出生日期、性别、年龄
     *
     * @param certificateNo
     * @return 返回的出生日期格式：1990-01-01   性别格式：F-女，M-男
     */
    public Map<String, String> getBirAgeSex(String certificateNo) {
        String birthday = "";
        String sexCode = "";

        int year = Calendar.getInstance().get(Calendar.YEAR);
        char[] number = certificateNo.toCharArray();
        boolean flag = true;
        if (number.length == 15) {
            for (int x = 0; x < number.length; x++) {
                if (!flag) return new HashMap<String, String>();
                flag = Character.isDigit(number[x]);
            }
        } else if (number.length == 18) {
            for (int x = 0; x < number.length - 1; x++) {
                if (!flag) return new HashMap<String, String>();
                flag = Character.isDigit(number[x]);
            }
        }
        if (flag && certificateNo.length() == 15) {
            birthday = "19" + certificateNo.substring(6, 8) + "-"
                    + certificateNo.substring(8, 10) + "-"
                    + certificateNo.substring(10, 12);
            sexCode = Integer.parseInt(certificateNo.substring(certificateNo.length() - 3, certificateNo.length())) % 2 == 0 ? "indexSex_1" : "indexSex_0";

        } else if (flag && certificateNo.length() == 18) {
            birthday = certificateNo.substring(6, 10) + "-"
                    + certificateNo.substring(10, 12) + "-"
                    + certificateNo.substring(12, 14);
            sexCode = Integer.parseInt(certificateNo.substring(certificateNo.length() - 4, certificateNo.length() - 1)) % 2 == 0 ? "indexSex_1" : "indexSex_0";

        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("birthday", birthday);
        map.put("sexCode", sexCode);
        return map;
    }
}
