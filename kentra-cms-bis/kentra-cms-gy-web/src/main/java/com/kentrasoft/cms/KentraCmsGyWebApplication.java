package com.kentrasoft.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
//启用feign调用接口
@EnableFeignClients
public class KentraCmsGyWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(KentraCmsGyWebApplication.class, args);
    }
}
