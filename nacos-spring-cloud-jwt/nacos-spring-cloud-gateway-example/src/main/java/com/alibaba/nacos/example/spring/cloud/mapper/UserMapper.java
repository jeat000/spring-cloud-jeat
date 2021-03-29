package com.alibaba.nacos.example.spring.cloud.mapper;

import com.alibaba.nacos.example.spring.cloud.model.MyUserDetails;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<MyUserDetails> {
    MyUserDetails getByUsername(@Param("username") String username, @Param("password") String password);
}
