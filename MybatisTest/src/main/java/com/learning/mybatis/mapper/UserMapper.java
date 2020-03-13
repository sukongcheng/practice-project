package com.learning.mybatis.mapper;

import com.learning.mybatis.entity.User;

import java.util.List;

public interface UserMapper {

    public int insertUser(User user) throws Exception;

    public int updateUser(User user) throws Exception;

    public int deleteUser(Integer id) throws Exception;

    public User selectUserById(Integer id) throws Exception;

    public List<User> selectAllUser() throws Exception;
}
