package com.kentrasoft.cms.sms.bean;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SmsMapCodeParams {


    public static Map<String, Object> params = new HashMap();

    public static String getParams(String phone) {
        if (params.get(phone) != null && params.get(phone) != "") {
            return params.get(phone).toString();
        }
        return null;
    }

    public static void setParams(String phone, String code) {
        SmsMapCodeParams.params.put(phone, code);
    }

}
