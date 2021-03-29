package com.example.shardingjdbcdemo.model;

import lombok.Data;

@Data
public class Goods {
    private Long gid;
    private String gname;
    private Long userId;
    private String gstatus;
}
