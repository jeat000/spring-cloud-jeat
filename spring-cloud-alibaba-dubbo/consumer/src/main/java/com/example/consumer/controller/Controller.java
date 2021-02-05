package com.example.consumer.controller;

import com.example.basespi.service.TestService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @DubboReference
    TestService service;

    @GetMapping("/test")
    public String test() {
        return service.hello("dubbo");
    }
}
