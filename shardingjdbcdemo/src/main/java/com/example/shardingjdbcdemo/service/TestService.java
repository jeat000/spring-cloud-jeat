package com.example.shardingjdbcdemo.service;

import com.example.shardingjdbcdemo.mapper.GoodsMapper;
import com.example.shardingjdbcdemo.model.Goods;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {

    @Autowired
    private GoodsMapper mapper;

    //分库分表事务 回滚测试   支持TransactionType.LOCAL, TransactionType.XA, TransactionType.BASE  BASE其实是 SEATA
    @Transactional(transactionManager = "shardingTransactionManager", rollbackFor = Exception.class)
    @ShardingTransactionType(TransactionType.XA)
    public void addGoods() {
        Goods good = new Goods();
        good.setGname("小米手机");
        good.setGstatus("已发布");

        //goods 库1
        good.setUserId(70L);
        for (int i = 0; i < 10; i++) {
            mapper.insert(good);
        }

        //goods 库2
        good.setUserId(71L);
        for (int i = 0; i < 10; i++) {
            mapper.insert(good);
        }

        //抛出异常 测试 分库分表后的 事务
        throw new RuntimeException();
    }

}
