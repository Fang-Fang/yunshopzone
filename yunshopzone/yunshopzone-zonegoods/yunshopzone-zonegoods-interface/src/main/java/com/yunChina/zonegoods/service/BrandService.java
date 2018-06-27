package com.yunChina.zonegoods.service;

import com.yunChina.pojo.TbBrand;
import com.yunChina.service.BaseService;
import com.yunChina.vo.PageResult;

import java.io.Serializable;
import java.util.List;

/**
 * Date:2018/6/25
 * Author: Fong.x
 * Desc:
 */
public interface BrandService extends BaseService<TbBrand> {
    PageResult findPage(Integer pageNum, Integer rows);

    void save(TbBrand tbBrand);

    TbBrand findById(Long id);

    void updateBrand(TbBrand tbBrand);

    void deleteBrands(Long[] ids);

    PageResult search(Integer pageNum, Integer rows, TbBrand tbBrand);
}
