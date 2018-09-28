package com.kentrasoft.cms.web.controller.customer;

import com.kentrasoft.cms.basic.properties.Properties;
import com.kentrasoft.cms.common.cache.util.RedisUtil;
import com.kentrasoft.cms.dao.DrivingLicenseMapper;
import com.kentrasoft.cms.entity.Customer;
import com.kentrasoft.cms.entity.DrivingLicense;
import com.kentrasoft.cms.entity.UpdatePwd;
import com.kentrasoft.cms.service.CustomerService;
import com.kentrasoft.cms.service.DrivingLicenseService;
import com.kentrasoft.cms.sms.bean.SmsMapCodeParams;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.tools.AppUtil;
import com.kentrasoft.utils.tools.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


@RestController
@RequestMapping("/customer/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private DrivingLicenseService drivingLicenseService;
    @Autowired
    private DrivingLicenseMapper drivingLicenseMapper;

    // 验证码超时时间
    public static final int CODE_TIME_OUT = 100000;
    // 验证码发送后间隔时间
    public static final int CODE_SEND_INTEVEL = 90000;

    @Autowired
    private Properties properties;


    @Autowired
    private SmsMapCodeParams smsMapCodeParams;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 用户登录
     *
     * @param phone 手机号，code 验证码
     * @return
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping("login")
    public BaseResult login(String phone, String code, String password) throws Exception {
        Boolean flag = false;
        if (!StringUtils.isBlank(code)) {
            String paramsCode = smsMapCodeParams.getParams(phone);
            try {
                if (code.equals(paramsCode) && StringUtils.isNotBlank(paramsCode)) {
                    flag = true;
                    return customerService.login(phone, null);
                } else {
                    return BaseResult.faild("登录失败！");
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            } finally {
                if (flag) {
                    //登陆成功从map中移除此次的验证码
                    smsMapCodeParams.params.remove(phone);
                }
            }
        } else if (!StringUtils.isBlank(password)) {
            return customerService.login(phone, password);
        } else {
            return BaseResult.faild("登录失败！");
        }
    }

    /**
     * 修改密码
     *
     * @param updatePwd
     * @return
     */
    @RequestMapping("updatePwd")
    public BaseResult updatePwd(UpdatePwd updatePwd) {
        Long id = updatePwd.getId();
        String newPwd = updatePwd.getNewPwd();
        String oldPwd = updatePwd.getOldPwd();
        String phone = updatePwd.getPhone();

        Map<String, Object> params = new HashMap<>();
        if (id != null) {
            params.put("id", updatePwd.getId());
        } else {
            return BaseResult.faild("用户标识为空，修改失败!");
        }
        if (!StringUtils.isBlank(phone)) {
            params.put("phone", phone);
        } else {
            return BaseResult.faild("手机号码为空，修改失败!");
        }
        Customer customer = customerService.selectByIdPhone(params);
        if (customer == null) {
            return BaseResult.faild("无此用户！");
        } else if (!customer.getPassword().equals(MD5Util.string2MD5(oldPwd))) {
            return BaseResult.faild("旧密码错误！");
        }
        if (!StringUtils.isBlank(oldPwd)) {
            params.put("oldPwd", MD5Util.string2MD5(oldPwd));
        } else {
            return BaseResult.faild("旧密码为空，修改失败!");
        }
        if (!StringUtils.isBlank(newPwd)) {
            params.put("newPwd", MD5Util.string2MD5(newPwd));
        } else {
            return BaseResult.faild("新密码为空，修改失败!");
        }
        return customerService.updatePwd(params);
    }


    /**
     * 保存用户基本信息
     *
     * @param
     * @return
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping("addCustomerBasicInfo")
    public BaseResult addCustomerBasicInfo(Customer customer) {
        return customerService.edit(customer);
    }

    /**
     * 保存用户驾驶证信息
     *
     * @param
     * @return
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping("addCustomerDriverLicense")
    public BaseResult addCustomerDriverLicense(Customer customer) {
        return customerService.edit(customer);
    }

    /**
     * 保存用户行驶证信息
     *
     * @param
     * @return
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping("addCustomerDrivingLicense")
    public BaseResult addCustomerDrivingLicense(DrivingLicense drivingLicense) {
        //保存用户驾驶证信息
        if (drivingLicense != null) {
            String licenseNum = drivingLicense.getLicenseNum();
            List<DrivingLicense> license = drivingLicenseMapper.selectByLicNum(licenseNum);
            if (license.size() > 0) {
                return BaseResult.faild("该车牌号已存在");
            }
        }
        drivingLicenseService.add(drivingLicense);
        //返回
        return BaseResult.success("添加成功！");
    }

    /**
     * 查询用户基本信息
     *
     * @param
     * @return
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping("getCustomerInfo")
    public BaseResult getCustomerInfo(String id) {
        Customer customer = customerService.findById(Long.parseLong(id));
        customer.setDriveType((String)redisUtil.get(customer.getDriveType()));
        //返回用户
        return BaseResult.success("", customer);
    }

    /**
     * 查询行驶证信息
     *
     * @param
     * @return
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping("getDrivingLicense")
    public BaseResult getDrivingLicense(String customerId) {
        List<DrivingLicense> drivingLicenseList = drivingLicenseService.getDrivingLicense(customerId);
        for (int i = 0; i < drivingLicenseList.size(); i++) {
            DrivingLicense drivingLicense = drivingLicenseList.get(i);
            drivingLicense.setCarType((String) redisUtil.get(drivingLicense.getCarType()));
        }
        //返回行驶证信息
        return BaseResult.success("", drivingLicenseList);
    }

    /**
     * 修改用户默认行驶证
     *
     * @param
     * @return
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping("updateDrivingLicenseStatus")
    public BaseResult updateDrivingLicenseStatus(String id, String customerId) {
        drivingLicenseService.updateDrivingLicenseStatus(id, customerId);
        //返回
        return BaseResult.success("修改成功！");
    }

    /**
     * 删除用户行驶证
     *
     * @param
     * @return
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping("deleteDrivingLicense")
    public BaseResult deleteDrivingLicense(String id) {
        drivingLicenseService.delete(id);
        //返回
        return BaseResult.success("删除成功！");
    }

    /*****************************************分割线****************************************/

    /**
     * 验证码
     *
     * @param phone
     * @param request
     * @return
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/sendCode")
    @ResponseBody
    public BaseResult sendCode(String phone, HttpServletRequest request) {
        try {
            // 获取六位数验证码
//			long codeSendTime = getCurrentSession().getCodeSendTime();
            long codeSendTime = 100000;
            long currentTimeMillis = System.currentTimeMillis();
            if (codeSendTime > 0 && codeSendTime + CODE_SEND_INTEVEL > currentTimeMillis) {
                return BaseResult.faild("sendcode.time.invalidate");
            }
//			int min = 100000;
//			int max = 900000;
//			Random random = new Random();
            int code = AppUtil.getRandomNum();

            //发送验证码
            sendSMS(phone, code + "");

            //存入session
//			getCurrentSession().setTelphone(phone);
//			getCurrentSession().setCodeSendTime(currentTimeMillis);
//			getCurrentSession().setCode(code + "");

            System.out.println(code);
            return BaseResult.success("发送成功", code + "");
        } catch (Exception e) {
            return BaseResult.faild("e.getMessage()");
        }
    }

    // 发送短信验证码
    protected void sendSMS(String phone, String code) {
        String uri = "http://smssh1.253.com/msg/send/json";
        Map<String, String> httpParameter = new HashMap<>();
        httpParameter.put("apiName", "S4363776");//账号
        httpParameter.put("password", "pwd2582863");//密码
        httpParameter.put("mobile", phone);//手机号
        httpParameter.put("Cell", "");//扩展号
        httpParameter.put("SendTime", "");//发送时间，固定14位长度字符串，比如：20060912152435代表2006年9月12日15时24分35秒，为空表示立即发送
        httpParameter.put("Content", "您正在进行贵阳高速登录，你的验证码是: " + code + "。如非本人操作，请忽略该信息");
        //大于0的整数表明发送成功
        String result = doPost(uri, httpParameter, "GB2312");
    }

    public static String doPost(String url, Map<String, String> params, String encoding) {
        HttpPost post = null;
        String result = "";
        HttpResponse response = null;
        try {
            post = new HttpPost(url);
            post.addHeader("Connection", "close");
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
            post.setConfig(requestConfig);
            ArrayList<NameValuePair> paramPairs = new ArrayList<NameValuePair>();
            for (Entry<String, String> entry : params.entrySet()) {
                paramPairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(paramPairs, encoding);
            post.setEntity(formEntity);
            response = client.execute(post);
            System.out.println("response得到：" + response);
            HttpEntity entity = response.getEntity();
            System.out.println("entity得到：" + entity);
            result = EntityUtils.toString(entity, "UTF-8");
            System.out.println(result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            post.releaseConnection();
        }
        return result;
    }

    private static HttpClient client = HttpClients.custom().setRetryHandler(new HttpRequestRetryHandler() {
        @Override
        public boolean retryRequest(IOException exception, int executionCount, HttpContext arg2) {
            if (executionCount >= 4) {
                return false;
            }
            if (exception instanceof NoHttpResponseException) {
                return true;
            } else if (exception instanceof ClientProtocolException) {
                return true;
            }
            return false;
        }
    }).build();

    /**
     * 图片上传
     *
     * @param request
     * @param response
     * @param files
     * @return
     * @throws Exception
     * @version 1.0
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult upload(MultipartFile files,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fileName = "";
        System.out.println("上传开始-----------------------------");
        try {
            String fileType = files.getContentType().trim();
            // 如果上传的文件不是图片
            if (fileType.indexOf("image/") == -1) {
                return BaseResult.faild("上传的文件不是图片！");
            }
            String originalFilename = files.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            fileName = System.currentTimeMillis() + "." + suffix;

            String urlPath = properties.getCardportimgLinkaddress() + "/gy/";
            String dirPath = properties.getCardportimgCountaddress() + File.separator;

            File dirPathFile = new File(dirPath);
            if (!dirPathFile.exists()) {
                dirPathFile.mkdirs();
            }

            files.transferTo(new File(dirPath + fileName));
            System.out.println("上传结束-----------------------------");
            return BaseResult.success("上传成功！", urlPath + fileName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("上传报错-----------------------------");
            return BaseResult.faild("上传失败:" + e.getMessage());
        }
    }

}
