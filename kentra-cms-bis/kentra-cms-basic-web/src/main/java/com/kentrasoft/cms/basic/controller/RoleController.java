package com.kentrasoft.cms.basic.controller;

import com.kentrasoft.cms.basic.client.UserRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述：角色页面跳转控制controller
 *
 * @author zhangmengkang
 * @date 2018-6-7 10:25:16
 */
@RequestMapping("/role")
@Controller
public class RoleController {
    @Autowired
    private UserRemote userRemote;

    /**
     * 描述：跳转到角色列表页面
     *
     * @return
     */
    @RequestMapping(value = "/goListPage")
    public String goPageList(){
        return "system/role/role_list";
    }

    /**
     * 描述：跳转到角色新增页面
     *
     * @return
     */
    @RequestMapping(value = "/goAddPage")
    public String add(){
        return "system/role/role_add";
    }


    /**
     * 描述：跳转到角色编辑页面
     *
     * @return
     */
    @RequestMapping(value = "/goEditPage")
    public String edit(){
        return "system/role/role_edit";
    }

    /**
     * 角色赋权页面
     */
   @RequestMapping("/empowerment")
   public String role_empowerment() {
	   return "system/role/role_empowerment";
   }
   
   /**
    * 跳转到详情页面
    */
   @RequestMapping(value = "/goQueryPage")
   public String query(){
       return "system/role/role_query";
   }
   
}
