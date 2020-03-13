package com.learning.springbootTest.service;

import java.util.List;

public interface IBaseService<T> {

    Long save(T t);

    void delete(Long id);

    T selectById(Long id);

    void update(T t);

    List<T> list();
}
