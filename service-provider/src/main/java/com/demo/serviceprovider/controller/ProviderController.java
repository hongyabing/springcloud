package com.demo.serviceprovider.controller;

import com.demo.serviceprovider.ServiceProviderApplication;
import com.demo.serviceprovider.service.IRedisService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jason
 * @description: TODO
 * @date 2019/5/21 16:19
 */
@RestController
@RequestMapping(value = "/provider")
public class ProviderController {
    private final Logger log = (Logger) LoggerFactory.getLogger(ProviderController.class);

    @Autowired
    private IRedisService redisService;//redis缓存存储

    @GetMapping("/getRedis")
    public String redisData() {
        String info = (String)redisService.get("provide:code");
        if(StringUtils.isNotBlank(info)){
            log.error("ServiceProvider:"+info);
        }else{
            redisService.set("provide:code","123");
        }
        return "helloremote:"+info;
    }


}
