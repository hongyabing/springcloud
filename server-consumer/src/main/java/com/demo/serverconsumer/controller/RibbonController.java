package com.demo.serverconsumer.controller;

import com.demo.serverconsumer.service.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
        return restTemplate.getForObject("http://serviceprovider/hello", String.class);
    }

    @RequestMapping("/helloremote/{name}")
    public String hello(@PathVariable("name") String name){
        return helloRemote.hello(name);
    }



}
