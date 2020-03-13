package com.learning.springbootTest.dao;

import com.learning.springbootTest.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
