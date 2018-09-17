package com.kentrasoft.cms.bis;

import com.kentrasoft.cms.bis.entity.User;
import com.kentrasoft.cms.bis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KentraCmsBisApplicationTests {

	@Autowired
	private UserService userService;
	@Test
	public void contextLoads() {
		User user = userService.findById(1L);
		System.out.print(user.getUsername());
	}

}
