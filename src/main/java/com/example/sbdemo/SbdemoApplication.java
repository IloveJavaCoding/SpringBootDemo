package com.example.sbdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@MapperScan("com.example.sbdemo.mapper")//mapper 接口包位置
@EntityScan("com.example.sbdemo.dao")//entity/dao 数据库实体类位置
public class SbdemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SbdemoApplication.class, args);
    }
}
