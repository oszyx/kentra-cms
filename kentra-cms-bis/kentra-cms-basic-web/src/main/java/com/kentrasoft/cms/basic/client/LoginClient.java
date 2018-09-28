package com.kentrasoft.cms.basic.client;

import java.util.HashMap;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="kentra-cms-basicApi")
@Component(value = "loginCliet")
public interface LoginClient {
     
	@RequestMapping("/sys/login")
	public HashMap<String,String> userLogin(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password);
	
	@RequestMapping("/sys/loadIndex")
	public HashMap<String,Object> loadIndex(@RequestParam(name = "cookie") String KentrasoftToken);
}
