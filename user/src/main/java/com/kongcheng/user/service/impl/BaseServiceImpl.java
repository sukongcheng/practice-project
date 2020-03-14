package com.kongcheng.user.service.impl;

import com.kongcheng.user.mapper.BaseMapper;
import com.kongcheng.user.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    protected BaseMapper<T> baseMapper;

    @Override
    public void save(T t) {
        baseMapper.save(t);
    }

    @Override
    public T findById(Long id) {
        return baseMapper.findById(id);
    }

    @Override
    public void update(T t) {
        baseMapper.update(t);
    }

    @Override
    public void delete(Long id) {
        baseMapper.delete(id);
    }

    @Override
    public List<T> list() {
        return baseMapper.list();
    }
}
