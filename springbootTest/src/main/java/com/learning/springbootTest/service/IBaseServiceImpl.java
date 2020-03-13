package com.learning.springbootTest.service;

import com.learning.springbootTest.dao.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
public class IBaseServiceImpl<T> implements IBaseService<T> {

    @Autowired
    protected BaseMapper<T> baseMapper;

    @Override
    public Long save(T t) {
        return baseMapper.save(t);
    }

    @Override
    public void delete(Long id) {
        baseMapper.delete(id);
    }

    @Override
    public T selectById(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public void update(T t) {
        baseMapper.update(t);
    }

    @Override
    public List<T> list() {
        return baseMapper.list();
    }
}
