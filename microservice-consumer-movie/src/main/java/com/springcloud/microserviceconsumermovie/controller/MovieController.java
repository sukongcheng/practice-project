package com.springcloud.microserviceconsumermovie.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.microserviceconsumermovie.entity.User;
import com.springcloud.microserviceconsumermovie.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RequestMapping("/movies")
@RestController
public class MovieController {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        //不使用Feign
//        User user = restTemplate.getForObject("http://microservice-provider-user/users/{id}", User.class, id);
        return userFeignClient.findById(id);
    }

    public User findByIdFallback(Long id){
        return new User(id, "default username", "default name", 0, new BigDecimal("0.00"));
    }
}
