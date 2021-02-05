package com.example.provider.service.impl;

import com.example.basespi.service.TestService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class ServiceImpl implements TestService {
    @Override
    public String hello(String name) {
        return "hello  " +name;
    }
}
