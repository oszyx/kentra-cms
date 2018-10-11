package com.kentrasoft.cms.basic.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@FeignClient(value="kentra-cms-basicApi")
@Component(value = "loginCliet")
public interface LoginClient {
     
	@RequestMapping("/cms/login")
	public HashMap<String,String> userLogin(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password);
	
	@RequestMapping("/cms/loadIndex")
	public HashMap<String,Object> loadIndex(@RequestParam(name = "cookie") String KentrasoftToken);
}
