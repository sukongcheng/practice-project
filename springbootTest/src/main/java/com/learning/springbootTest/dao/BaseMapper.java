package com.learning.springbootTest.dao;

import java.util.List;


public interface BaseMapper<T> {

    Long save(T t);

    void delete(Long id);

    T selectById(Long id);

    void update(T t);

    List<T> list();
}
