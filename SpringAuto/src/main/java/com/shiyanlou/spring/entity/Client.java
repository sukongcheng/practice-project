package com.shiyanlou.spring.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class Client {
    @Autowired
    private Service service;

    public void sayHello(){
        service.sayHello();
    }
}
