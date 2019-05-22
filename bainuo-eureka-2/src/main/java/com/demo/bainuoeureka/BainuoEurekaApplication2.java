package com.demo.bainuoeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BainuoEurekaApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(BainuoEurekaApplication2.class, args);
    }

}
