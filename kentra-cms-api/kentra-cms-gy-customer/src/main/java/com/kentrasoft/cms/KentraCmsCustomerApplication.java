package com.kentrasoft.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.kentrasoft.cms.dao")
public class KentraCmsCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KentraCmsCustomerApplication.class, args);
    }

}
