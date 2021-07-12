package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.demo.System.user.mapper")
public class ControlleraspectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlleraspectApplication.class, args);
    }

}
