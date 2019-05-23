package com.demo.serverconsumer.controller;

import com.demo.serverconsumer.service.HelloRemote;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author Jason
 * @description: TODO
 * @date 2019/5/20 19:14
 */
@RestController
@RequestMapping("/consumer")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HelloRemote helloRemote;

    @RequestMapping("/ribbon")
    public String getMsg() {
        //这里的服务名，不能有下划线或者中斜杠，不然请求报错：No instances available for server-provider
        ResponseEntity<String>  responseEntity = restTemplate.getForEntity("http://serviceprovider/hello",String.class);
        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.getStatusCodeValue());
        System.out.println(responseEntity.getBody());
        return restTemplate.getForObject("http://serviceprovider/hello", String.class);
    }

    @LoadBalanced
    @HystrixCommand(fallbackMethod = "error")
    @RequestMapping(value = "/helloremote/{name}",produces = {"application/json; charset=utf-8"})
    public String hello(@PathVariable("name") String name){
        return helloRemote.hello(name);
    }



    private String error() {
        System.out.println("熔断，默认回调函数");
        return "熔断，默认回调函数";
    }


}
