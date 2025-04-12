package com.aliyun.oss;

import org.springframework.boot.context.properties.EnableConfigurationProperties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AliOssProperties.class)
public class AliOSSAutoConfiguration {


    @Bean
    public AliOSSUtils aliOSSUtils(AliOssProperties aliOssProperties) {
        AliOSSUtils aliOSSUtils = new AliOSSUtils();
        aliOSSUtils.setAliOssProperties(aliOssProperties);
        System.out.println(aliOSSUtils.getAliOssProperties());
        return aliOSSUtils;
    }
}
