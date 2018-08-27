package com.kentrasoft.cmsa.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class KentraCmsRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(KentraCmsRegistryApplication.class, args);
	}
}
