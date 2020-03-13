package com.learning.springboot.first;

import com.learning.springboot.first.UserOne;
import com.learning.springboot.first.UserOneRepository;
import com.learning.springboot.first.UserOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserOneServiceImpl implements UserOneService {

    @Autowired
    private UserOneRepository userOneRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserOne save(UserOne userOne) {
        return userOneRepository.save(userOne);
    }
}
