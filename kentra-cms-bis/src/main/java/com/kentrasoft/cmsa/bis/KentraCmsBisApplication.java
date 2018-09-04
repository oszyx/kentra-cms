package com.kentrasoft.cmsa.bis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.kentrasoft.cmsa.bis.dao")
public class KentraCmsBisApplication {

	public static void main(String[] args) {
		SpringApplication.run(KentraCmsBisApplication.class, args);
	}
}
