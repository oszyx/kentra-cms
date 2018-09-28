package com.kentrasoft.cms.basic.controller;

import com.kentrasoft.cms.basic.client.LoginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
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
    @RequestMapping("/gyfvs")
    public String login(Model model) {
        model.addAttribute("hello", "welcome to platform");
        return "login.html";
    }

    /**
     * 首页
     *author:赵参谋
     * @param id
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
        HashMap<String, Object> viewInfos = loginClient.loadIndex(KentrasoftToken);
        model.addAttribute("ViewInfos", viewInfos);
        return "index.html";
    }
    /**
     * 个人信息首页
     *author:赵参谋
     * @return
     */
   @RequestMapping("/sys/userInfos")
   public String userInfos() {
	   return "system/index/user_info.html";
   }
   /**
    * 重置密码
    *author:赵参谋
    * @return
    */
   @RequestMapping("/sys/resetPassword")
   public String resetPassword() {
	   return "system/index/user_resetpassword.html";
   }
   /**
    * 退出登录
    *author:赵参谋
    * @return
    */
   /*@RequestMapping("/sys/backLogin")
   public String backLogin() {
	   return "redirect:/kentrasoft";
   }*/
   
   /**
    * 重新登录
    *author:赵参谋
    * @return
    */
   @RequestMapping("/sys/resetLogin")
   public String resetLogin() {
	   return "system/index/resetLogin.html";
   }
}
