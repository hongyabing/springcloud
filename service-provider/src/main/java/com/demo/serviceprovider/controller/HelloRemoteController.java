package com.demo.serviceprovider.controller;

import com.demo.serviceprovider.service.IRedisService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jason
 * @description: TODO
 * @date 2019/5/21 20:26
 */
@RestController
public class HelloRemoteController {
    private final Logger log = (Logger) LoggerFactory.getLogger(ProviderController.class);

    @Autowired
    private IRedisService redisService;//redis缓存存储

    @GetMapping("/hello")
    public String helloRemote(String name) {
        String info = (String)redisService.get("provide:code");
        if(StringUtils.isNotBlank(info)){
            log.error("ServiceProvider:"+name);
        }else{
            redisService.set("provide:code","123");
        }
        return "helloremote:"+info+"---"+name;
    }
}
