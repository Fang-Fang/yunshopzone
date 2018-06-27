package com.yunChina.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunChina.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.io.Serializable;
import java.util.List;

/**
 * Date:2018/6/26
 * Author: Fong.x
 * Desc:
 */
public class BaseServiceImpl<T> implements BaseService<T>{

    @Autowired
    private Mapper<T> mapper;

    @Override
    public T findOne(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> findAll() {
        return mapper.selectAll();
    }

    @Override
    public List<T> findByWhere(T t) {
        return mapper.selectByExample(t);
    }

    @Override
    public void add(T t) {
        mapper.insertSelective(t);
    }

    @Override
    public void deleteOne(Long id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteBatch(Serializable[] ids) {
        for(Serializable id : ids){
            mapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void update(T t) {
        mapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public PageResult findByPage(Integer pageNum, Integer rows) {
        PageHelper.startPage(pageNum,rows);
        List<T> results = mapper.selectAll();
        PageInfo<T> pageInfo = new PageInfo<>(results, rows);
        return new PageResult(pageInfo.getTotal(),results);
    }

    @Override
    public PageResult findByPage(Integer pageNum, Integer rows, T t) {
        PageHelper.startPage(pageNum,rows);
        List<T> results = mapper.selectByExample(t);
        PageInfo<T> pageInfo = new PageInfo<>(results, rows);
        return new PageResult(pageInfo.getTotal(),results);
    }
}
