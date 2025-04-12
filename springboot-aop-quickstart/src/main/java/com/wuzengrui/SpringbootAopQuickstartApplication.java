package com.wuzengrui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
@MapperScan("com.wuzengrui.mapper")
public class SpringbootAopQuickstartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAopQuickstartApplication.class, args);
    }

}
