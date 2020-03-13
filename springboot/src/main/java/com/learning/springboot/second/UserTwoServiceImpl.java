package com.learning.springboot.second;

import com.learning.springboot.second.UserTwo;
import com.learning.springboot.second.UserTwoRepository;
import com.learning.springboot.second.UserTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserTwoServiceImpl implements UserTwoService {

    @Autowired
    private UserTwoRepository userTwoRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserTwo save(UserTwo userTwo) {
        return userTwoRepository.save(userTwo);
    }
}
