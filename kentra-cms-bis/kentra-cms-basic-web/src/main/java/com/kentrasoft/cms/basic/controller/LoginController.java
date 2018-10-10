package com.kentrasoft.cms.basic.controller;

import com.kentrasoft.cms.basic.client.LoginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private LoginClient loginClient;

    /**
     * Author 赵参谋
     * Describe:登录首页
     */
    @RequestMapping("/bis")
    public String login(Model model) {
        model.addAttribute("hello", "welcome to platform");
        return "login.html";
    }

    /**
     * 首页
     *author:赵参谋
     * @param model
     * @return
     */
    @RequestMapping(value = "/sys/index")
    public String loadindex(HttpServletRequest request, Model model) {
    	Cookie[] cookies = request.getCookies();
        String KentrasoftToken="";
    	for(Cookie cookie:cookies) {
    		if("KentrasoftToken".equals(cookie.getName())) {
    			KentrasoftToken=cookie.getValue();
    		}
    	}
        //HashMap<String, Object> viewInfos = loginClient.loadIndex(KentrasoftToken);
        //model.addAttribute("ViewInfos", viewInfos);
        return "index.html";
    }
}
