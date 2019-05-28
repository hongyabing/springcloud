package com.demo.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "serviceprovider")
public interface HelloService {
    @RequestMapping("/hello")
    String hello();
}
