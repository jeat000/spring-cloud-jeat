package com.alibaba.nacos.example.spring.cloud.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResultModel {
    private String status;
    private String notes;
    private String token;
}
