package com.xuzhao.aigou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //eureka的客户端
@MapperScan("com.xuzhao.aigou.mapper")
public class ProductApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication8002.class);
    }
}
