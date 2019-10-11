package com.didispace;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConfigController {

    @Value("${info.from}")
    private String from;

    @Value("${spring.name}")
    private String name;

    @GetMapping("from")
    public String from() {
        return from;
    }

    @GetMapping("name")
    public String name() {
        return name;
    }
}
