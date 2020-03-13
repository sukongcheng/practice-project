package com.learning.springboot;

import com.learning.springboot.first.UserOne;
import com.learning.springboot.second.UserTwo;
import com.learning.springboot.first.UserOneService;
import com.learning.springboot.second.UserTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Test implements ApplicationRunner {

//    @Autowired
//    private UserService userService;
    @Autowired
    private UserOneService userOneService;
    @Autowired
    private UserTwoService userTwoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        User user = new User();
//        user.setUserName("Andy");
//        user.setPassword("123456");
//        user.setSex("male");
//        user.setAddress("nanjing");
//        userService.save(user);
        UserOne one = new UserOne();
        one.setUserName("Tom");
        one.setPassword("123456");
        userOneService.save(one);

        UserTwo two = new UserTwo();
        two.setUserName("Andy");
        two.setPassword("789465");
        userTwoService.save(two);

    }
}
