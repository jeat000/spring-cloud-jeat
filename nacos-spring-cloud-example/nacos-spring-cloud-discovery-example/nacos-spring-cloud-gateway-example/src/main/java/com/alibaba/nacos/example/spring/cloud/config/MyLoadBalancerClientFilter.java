package com.alibaba.nacos.example.spring.cloud.config;

import org.springframework.cloud.gateway.config.LoadBalancerProperties;
import org.springframework.cloud.gateway.filter.ReactiveLoadBalancerClientFilter;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.stereotype.Component;


@Component
public class MyLoadBalancerClientFilter extends ReactiveLoadBalancerClientFilter {
    public MyLoadBalancerClientFilter(LoadBalancerClientFactory clientFactory, LoadBalancerProperties properties) {
        super(clientFactory, properties);
    }
}
