package com.yunChina.service;

import com.yunChina.pojo.TbBrand;
import com.yunChina.vo.PageResult;

import java.io.Serializable;
import java.util.List;

/**
 * Date:2018/6/26
 * Author: Fong.x
 * Desc:
 */
public interface BaseService<T> {
    /**
     * 根据id查询
     */
    T findOne(Long id);

    /**
     * 查询所有
     */
    List<T> findAll();

    /**
     * 根据条件查询
     */
    List<T> findByWhere(T t);

    /**
     * 新增数据
     */
    void add(T t);

    /**
     * 根据id删除数据
     */
    void deleteOne(Long id);

    /**
     * 批量删除
     */
    void deleteBatch(Serializable[] ids);

    /**
     * 修改数据
     */
    void update(T t);

    /**
     * 分页查询
     */
    PageResult findByPage(Integer pageNum, Integer rows);

    /**
     * 根据条件分页查询
     */
    PageResult findByPage(Integer pageNum, Integer rows, T t);
}
