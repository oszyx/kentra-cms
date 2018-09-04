package com.kentrasoft.cmsa.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication //(exclude= {DataSourceAutoConfiguration.class})
public class KentraCmsGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(KentraCmsGatewayApplication.class, args);
	}
}
