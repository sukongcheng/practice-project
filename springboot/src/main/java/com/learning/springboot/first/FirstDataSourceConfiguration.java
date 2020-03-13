package com.learning.springboot.first;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.learning.springboot.first"},
        entityManagerFactoryRef = "entityManagerFactoryFirst",
        transactionManagerRef = "transactionManagerFirst"
)
public class FirstDataSourceConfiguration {

    private final DataSource firstDataSource;

    @Autowired
    public FirstDataSourceConfiguration(@Qualifier("firstDataSource") DataSource firstDataSource) {
        this.firstDataSource = firstDataSource;
    }

    /**
     * 配置entityManager工厂
     * @param builder
     * @return
     */
    @Bean(name = "entityManagerFactoryFirst")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryFirst(EntityManagerFactoryBuilder builder){
        return builder
                .dataSource(firstDataSource)
                .packages("com.learning.springboot.first")
                .build();
    }

    /**
     * 配置事务管理器
     */
    @Bean(name = "transactionManagerFirst")
    public PlatformTransactionManager transactionManagerFirst(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(entityManagerFactoryFirst(builder).getObject());
    }
}
