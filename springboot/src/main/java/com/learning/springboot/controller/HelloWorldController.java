package com.learning.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@PropertySource(value = "classpath:test.properties")
@Controller
public class HelloWorldController {

//    @Value("${love.string1}")
//    private String str;

    @RequestMapping("hello")
    public String helloWorld() {
        return "test";
    }
}
