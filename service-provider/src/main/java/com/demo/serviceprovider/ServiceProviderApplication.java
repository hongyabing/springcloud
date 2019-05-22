package com.demo.serviceprovider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceProviderApplication {

    private final Logger log = (Logger) LoggerFactory.getLogger(ServiceProviderApplication.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderApplication.class, args);
    }


    @RequestMapping(name = "/hello", method = RequestMethod.GET)
    public String index() {
        log.error("ServiceProvider, "+discoveryClient.getServices().toString()+" ip :"+8084);
        System.out.println("ServiceProvider, "+discoveryClient.getServices().toString()+" ip :"+8084);
        return "Hello SpringCloud~ ServiceProvider 8084";
    }

}
