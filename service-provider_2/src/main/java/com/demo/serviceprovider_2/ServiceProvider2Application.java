package com.demo.serviceprovider_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceProvider2Application {

    private final Logger log = (Logger) LoggerFactory.getLogger(ServiceProvider2Application.class);

    @Autowired
    private DiscoveryClient discoveryClient;


    public static void main(String[] args) {
        SpringApplication.run(ServiceProvider2Application.class, args);
    }


    @RequestMapping(name = "/hello", method = RequestMethod.GET)
    public String index() {
        log.info("ServiceProvider, "+discoveryClient.getServices().toString()+" ip :"+8085);
        return "Hello SpringCloud~ ServiceProvider 8085";
    }
}
