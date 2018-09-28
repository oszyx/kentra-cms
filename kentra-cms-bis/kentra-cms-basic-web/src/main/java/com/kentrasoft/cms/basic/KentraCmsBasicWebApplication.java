package com.kentrasoft.cms.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class})
//启用注册中心
@EnableDiscoveryClient
//启用feign调用接口
@EnableFeignClients
public class KentraCmsBasicWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(KentraCmsBasicWebApplication.class, args);
    }
}
