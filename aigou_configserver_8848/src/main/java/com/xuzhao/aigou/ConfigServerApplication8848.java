package com.xuzhao.aigou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer //开启配置中心
public class ConfigServerApplication8848 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication8848.class);
    }
}
