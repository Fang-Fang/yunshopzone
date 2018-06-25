package com.yunChina.zonegoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yunChina.mapper.BrandMapper;
import com.yunChina.pojo.TbBrand;
import com.yunChina.zonegoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Date:2018/6/25
 * Author: Fong.x
 * Desc:
 */
@Service(interfaceClass = BrandService.class)
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<TbBrand> findAll() {
        return brandMapper.queryAll();
    }
}
