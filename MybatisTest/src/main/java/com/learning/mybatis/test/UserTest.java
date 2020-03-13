package com.learning.mybatis.test;

import com.learning.mybatis.entity.User;
import com.learning.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    private static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) {
        String resource = "mybatisConfig.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        insertUser();
//        updateUser();
        selectUserById();
//        selectAllUser();
    }


    private static void insertUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUserName("Tom");
        user.setPassword("123456");
        user.setSex("male");
        user.setAddress("chengdu");

        try {
            mapper.insertUser(user);

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
        sqlSession.close();
    }

    private static void updateUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = null;
        try {
            user = mapper.selectUserById(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        user.setAddress("changzhou");
        try {
            mapper.updateUser(user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }

        sqlSession.close();
    }

    private static void deleteUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = null;
        try {
            user = mapper.selectUserById(1);
            mapper.deleteUser(user.getId());
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
        sqlSession.close();
    }

    private static void selectUserById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        try {
            User user = mapper.selectUserById(1);
            sqlSession.commit();
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
        sqlSession.close();
    }

    private static void selectAllUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        try {
            List<User> userList = mapper.selectAllUser();
            sqlSession.commit();
            userList.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }

        sqlSession.close();
    }
}
