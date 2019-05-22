package com.demo.serverconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 使用feign来调用注册中心的接口 name 就是对应注册服务中的应用名字
　　* @author Jason
　　* @date 2019/5/21 20:01
　　*/
@FeignClient(name = "serviceprovider")
public interface HelloRemote {

    // //这里调用的是注册中心的提供的服务、serviceprovider这个实例名的项目中的代码
    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name);
}
