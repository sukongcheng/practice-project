package com.shiyanlou.spring.config;

import com.shiyanlou.spring.entity.Client;
import com.shiyanlou.spring.entity.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public Service service(){
        return new Service();
    }

    @Bean
    public Client client(){
        return new Client();
    }
}
