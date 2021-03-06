package com.springcloud.microserviceprovideruser.controller;

import com.springcloud.microserviceprovideruser.dao.UserRepository;
import com.springcloud.microserviceprovideruser.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("{id}")
    public Optional<User> findById(@PathVariable Long id){
        return userRepository.findById(id);
    }
}
