package com.kentrasoft.cms.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication //(exclude= {DataSourceAutoConfiguration.class})
@ComponentScan("com.kentrasoft.cms")
public class KentraCmsGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(KentraCmsGatewayApplication.class, args);
	}
}
