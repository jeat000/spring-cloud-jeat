package com.alibaba.nacos.example.spring.cloud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HttpResult {

    private int code = 200;
    private String msg;
    private Object data;
}
