package com.learning.springboot.second;


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
        basePackages = {"com.learning.springboot.second"},
        entityManagerFactoryRef = "entityManagerFactorySecond",
        transactionManagerRef = "transactionManagerSecond"
)
public class SecondDataSourceConfiguration {

    private final DataSource secondDataSource;

    @Autowired
    public SecondDataSourceConfiguration(@Qualifier("secondDataSource") DataSource secondDataSource) {
        this.secondDataSource = secondDataSource;
    }

    /**
     * 配置entityManager工厂
     * @param builder
     * @return
     */
    @Bean(name = "entityManagerFactorySecond")
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySecond(EntityManagerFactoryBuilder builder){
        return builder
                .dataSource(secondDataSource)
                .packages("com.learning.springboot.Second")
                .build();
    }

    /**
     * 配置事务管理器
     */
    @Bean(name = "transactionManagerSecond")
    public PlatformTransactionManager transactionManagerSecond(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(entityManagerFactorySecond(builder).getObject());
    }
}
