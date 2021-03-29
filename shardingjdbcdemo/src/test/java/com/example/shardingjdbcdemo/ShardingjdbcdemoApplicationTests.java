package com.example.shardingjdbcdemo;

import com.example.shardingjdbcdemo.mapper.GoodsMapper;
import com.example.shardingjdbcdemo.mapper.UserMapper;
import com.example.shardingjdbcdemo.model.Goods;
import com.example.shardingjdbcdemo.model.User;
import com.example.shardingjdbcdemo.normalmapper.GoodsMapperNormal;
import com.example.shardingjdbcdemo.service.TestService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shardingsphere.shardingjdbc.spring.boot.sharding.SpringBootShardingRuleConfigurationProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ShardingjdbcdemoApplicationTests {

    //分库分表的mapper  会自动修改表名
    @Autowired
    private GoodsMapper mapper;

    @Autowired
    private UserMapper userMapper;

    //普通mybatis mapper
    @Autowired
    private GoodsMapperNormal normalMapper;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private TestService service;

    @Test
    void test() {
//        DataSource bean = context.getBean(DataSource.class);
        SqlSessionFactory factory = (SqlSessionFactory) context.getBean("shardingSqlSessionFactory");
        SpringBootShardingRuleConfigurationProperties bean1 = context.getBean(SpringBootShardingRuleConfigurationProperties.class);
        System.out.println("2313");
    }

    //分库分表插入数据测试
    @Test
    void addGoods() {
        Goods good = new Goods();
        good.setGname("小米手机");
        good.setGstatus("已发布");

        //goods 库1
        good.setUserId(77L);
        for (int i = 0; i < 50; i++) {
            mapper.insert(good);
        }

        //goods 库2
        good.setUserId(78L);
        for (int i = 0; i < 50; i++) {
            mapper.insert(good);
        }
    }

    //sharding 分库分表后查询
    @Test
    void getAllGoods() {
        List<Map<String, Object>> list = mapper.selectAll();
        list.forEach(o -> {
            System.out.println(o.toString());
        });
    }

    //垂直拆分  普通mybatis 查询
    @Test
    void getAllGoodsNormal() {
        List<Map<String, Object>> list = normalMapper.selectAll();
        list.forEach(o -> {
            System.out.println(o.toString());
        });
    }

    //分库分表后 事务回滚测试
    @Test
    void testTrasaction() {
        service.addGoods();
    }

    @Test
    void insertUsers() {
        User user = new User();
        user.setId(100L);
        user.setUserName("aaaaaaaaaaaaa");
        userMapper.insert(user);
        user.setId(99L);
        userMapper.insert(user);
    }

    //2张表， 分库分表后 关联查询
    @Test
    void getAllGoodsWithUser() {
        List<Map<String, Object>> allGoodsWithUser = mapper.getAllGoodsWithUser();
        System.out.println(allGoodsWithUser.size());
        allGoodsWithUser.forEach(o -> {
            System.out.println(o.toString());
        });
    }

}
