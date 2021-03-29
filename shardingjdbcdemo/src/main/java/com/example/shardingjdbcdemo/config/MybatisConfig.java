package com.example.shardingjdbcdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 普通mybatis 配置
 */
@Configuration
@MapperScan(basePackages = "com.example.shardingjdbcdemo.normalmapper", sqlSessionFactoryRef = "normalSqlSessionFactory")
public class MybatisConfig {

    //    创建数据源
    @Bean(name = "normalDB")
    @ConfigurationProperties(prefix = "spring.normal")
    public DataSource getNormalDataSource() {
        return new DruidDataSource();
    }

    // 创建SessionFactory
    @Bean(name = "normalSqlSessionFactory")
    public SqlSessionFactory normalSqlSessionFactory(@Qualifier("normalDB") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources("classpath:normalmapper/**/*.xml"));
        return bean.getObject();
    }

    // 创建事务管理器
    @Bean("normalTransactionManger")
    public DataSourceTransactionManager normalTransactionManger(@Qualifier("normalDB") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    // 创建SqlSessionTemplate
    @Bean(name = "normalSqlSessionTemplate")
    public SqlSessionTemplate normalSqlSessionTemplate(@Qualifier("normalSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
