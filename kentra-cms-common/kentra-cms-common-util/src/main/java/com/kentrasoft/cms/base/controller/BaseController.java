package com.kentrasoft.cms.base.controller;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * 描述：基础controller，封装controller的基础操作方法
 *
 * @author: ZYX
 * @date: 2018年1月24日 上午9:58:44
 */
public class BaseController {
    /**
     * 描述：获取参数对象
     *
     * @param: @return
     * @return: PageData
     */
    @SuppressWarnings("rawtypes")
    public HashMap<String, Object> getPageData() {
        Map properties = this.getRequest().getParameterMap();
        HashMap<String, Object> returnMap = new HashMap<String, Object>();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            } else {
                value = valueObj.toString();
            }
            if (!isBlank(value)) {
                returnMap.put(name, value);
            }
        }
        if (isNotEmpty((String) returnMap.get("orderField")) && isNotEmpty((String) returnMap.get("orderDirection"))) {
            returnMap.put("_orderBy", (String) returnMap.get("orderField") + "_" + (String) returnMap.get("orderDirection"));
        }
        return returnMap;
    }

    /**
     * 描述：获取request对象
     *
     * @param: @return
     * @return: HttpServletRequest
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    /**
     * 描述：获取response对象
     *
     * @param: @return
     * @return: HttpServletResponse
     */
    public HttpServletResponse getResponse() {
        HttpServletResponse response = (HttpServletResponse) ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        return response;
    }

    /**
     * 描述：判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        int strLen;
        if ((str == null) || ((strLen = str.length()) == 0)) {
            return true;
        }
        for (int i = 0; i < strLen; ++i) {
            if (!(Character.isWhitespace(str.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 描述：判断字符串是否有值
     *
     * @param origin
     * @return
     */
    public static boolean isNotEmpty(String origin) {
        return (origin != null && origin.trim().length() > 0);
    }


    /**
     * 描述：将cookie封装到Map
     *
     * @return
     */
    private Map<String, Cookie> getCookieMap() {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = this.getRequest().getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }


    /**
     * 描述：根据名字获取value
     *
     * @param name cookie名字
     * @return
     */
    public String getCookieByName(String name) {
        Map<String, Cookie> cookieMap = this.getCookieMap();
        if (cookieMap.containsKey(name)) {
            Cookie cookie = (Cookie) cookieMap.get(name);
            return cookie.getValue();
        } else {
            return null;
        }
    }

    /**
     * 描述：添加cookie
     *
     * @param name cookie 名称
     * @param value cookie 值
     * @param value cookie 过期时间
     */
    public void addCookie(String name, String value, Integer saveTime) {
        Cookie cookie = new Cookie(name.trim(), value.trim());
        // 设置为30min
        if (saveTime != null) {
            cookie.setMaxAge(saveTime);
        } else {
            cookie.setMaxAge(30 * 60);
        }
        cookie.setPath("/");
        this.getResponse().addCookie(cookie);
    }

    /**
     * 描述：修改cookie
     *
     * @param name
     * @param value
     */
    public void editCookie(String name, String value) {
        Cookie[] cookies = this.getRequest().getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    System.out.println("原值为:" + cookie.getValue());
                    cookie.setValue(value);
                    cookie.setPath("/");
                    // 设置为30min
                    cookie.setMaxAge(30 * 60);
                    System.out.println("被修改的cookie名字为:" + cookie.getName() + ",新值为:" + cookie.getValue());
                    this.getResponse().addCookie(cookie);
                    break;
                }
            }
        }
    }

    /**
     * 描述: 删除cookie
     *
     * @param name
     */
    public void delCookie(String name) {
        Cookie[] cookies = this.getRequest().getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    cookie.setValue(null);
                    // 立即销毁cookie
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    System.out.println("被删除的cookie名字为:" + cookie.getName());
                    this.getResponse().addCookie(cookie);
                    break;
                }
            }
        }
    }
}
