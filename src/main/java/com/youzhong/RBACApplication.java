package com.youzhong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.youzhong.dao")
public class RBACApplication {

    public static void main(String[] args) {
        SpringApplication.run(RBACApplication.class, args);
    }

}
