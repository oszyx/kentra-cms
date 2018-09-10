package com.kentrasoft.cms.common.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.kentrasoft.cms.common.cache")
public class KentraCmsCommonCacheApplication {
//    	@Bean
//	public RestTemplate restTemplate()    {
//		return new RestTemplate();
//	}
    public static void main(String[] args) {
        SpringApplication.run(KentraCmsCommonCacheApplication.class, args);
    }
}
