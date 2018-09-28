package com.kentrasoft.cms.sms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kentrasoft.cms.sms.bean.SmsMapCodeParams;
import com.kentrasoft.cms.sms.bean.SmsSendRequest;
import com.kentrasoft.cms.sms.bean.SmsSendResponse;
import com.kentrasoft.cms.sms.util.SmsUtil;
import com.kentrasoft.utils.plugin.BaseResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liyang
 * @Description:普通短信发送
 */
@RestController
@RequestMapping("/sms")
public class SendSmsController {

    @Autowired
    private SmsMapCodeParams smsMapCodeParams;

    private static final String charset = "utf-8";
    // 请登录zz.253.com 获取创蓝API账号(非登录账号,示例:N1234567)
    private static final String account = "N6605060";
    // 请登录zz.253.com 获取创蓝API密码(非登录密码)
    private static final String password = "d3YQqICEBr1562";
    //短信发送的URL 请登录zz.253.com 获取完整的URL接口信息
    private static final String smsSingleRequestServerUrl = "https://smssh1.253.com/msg/send/json";
    // 设置您要发送的内容：其中“【】”中括号为运营商签名符号，多签名内容前置添加提交
    private static final String msg = "【253云通讯】你好,你的验证码是:";

    @RequestMapping(value = "/sendMsg", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult sendMsg(@RequestBody String phone) {
        if (StringUtils.isBlank(phone)) {
            return BaseResult.faild("手机号不能为空!");
        }
        Map phoneParams = JSON.parseObject(phone);
        phone = phoneParams.get("phone").toString();
        //验证码随机6位数
        int random = (int) ((Math.random() * 9 + 1) * 100000);
        //短信内容2
        String msg1 = "" + random;
        //短信内容拼接
        String msg2 = msg + msg1 + ".";
        //状态报告
        String report = "true";

        SmsSendRequest smsSingleRequest = new SmsSendRequest(account, password, msg2, phone, report);
        String requestJson = JSON.toJSONString(smsSingleRequest);
//        System.out.println("before request string is: " + requestJson);

        String response = SmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);
//        System.out.println("response after request result is :" + response);
        JSONObject JSONObject = (JSONObject) JSON.parse(response);
        Map map = JSONObject;
        String code = (String) map.get("code");
        if (code.equals("0")) {
            smsMapCodeParams.setParams(phone, random + "");
            return BaseResult.success("发送成功!");
        }
        SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);
        System.out.println("response  toString is :" + smsSingleResponse);

        return BaseResult.faild("信息发送失败!");
    }
}
