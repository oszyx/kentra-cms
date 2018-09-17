package com.kentrasoft.cms.bis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.kentrasoft.cms.bis.dao")
@ComponentScan("com.kentrasoft.cms")
@EnableCaching
public class KentraCmsBisApplication {

	public static void main(String[] args) {
		SpringApplication.run(KentraCmsBisApplication.class, args);
	}
}
