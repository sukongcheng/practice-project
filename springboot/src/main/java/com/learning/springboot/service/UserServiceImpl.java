package com.learning.springboot.service;

import com.learning.springboot.dao.UserRepository;
import com.learning.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User save(User user) {
        userRepository.save(user);
        user.setSex("female");
//        int i = 1/0;
        return userRepository.save(user);
    }
}
