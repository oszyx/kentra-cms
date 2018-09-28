package com.kentrasoft.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

import java.util.Collections;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.kentrasoft.cms.dao")
@ComponentScan("com.kentrasoft.cms")
public class KentraCmsBasicApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(KentraCmsBasicApiApplication.class, args);
    }

    /**
     * 描述：时间转换插件
     *
     * @return
     */
    @Bean
    public ConversionService conversionService() {
        FormattingConversionServiceFactoryBean factory = new FormattingConversionServiceFactoryBean();
        DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
        registrar.setUseIsoFormat(true);
        factory.setFormatterRegistrars(Collections.singleton(registrar));
        factory.afterPropertiesSet();
        return factory.getObject();
    }
}
