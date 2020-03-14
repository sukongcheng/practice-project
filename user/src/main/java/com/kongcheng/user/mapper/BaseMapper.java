package com.kongcheng.user.mapper;

import java.util.List;

public interface BaseMapper<T> {

    Integer save(T t);

    T findById(Long id);

    Integer update(T t);

    Integer delete(Long id);

    List<T> list();
}
