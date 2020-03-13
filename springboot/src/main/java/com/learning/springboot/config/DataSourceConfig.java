package com.learning.springboot.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @Primary //主数据源
    @ConfigurationProperties("app.datasource.first") //读取前缀为app.datasource.first的属性
    public DataSourceProperties firstDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.first")
    public DataSource firstDataSource(){
        return firstDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @ConfigurationProperties("app.datasource.second") //读取前缀为app.datasource.first的属性
    public DataSourceProperties secondDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("app.datasource.second")
    public DataSource secondDataSource(){
        return secondDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
