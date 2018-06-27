package com.yunChina.zonegoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunChina.mapper.BrandMapper;
import com.yunChina.pojo.TbBrand;
import com.yunChina.service.BaseServiceImpl;
import com.yunChina.vo.PageResult;
import com.yunChina.zonegoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.List;

/**
 * Date:2018/6/25
 * Author: Fong.x
 * Desc:
 */
@Service(interfaceClass = BrandService.class)
public class BrandServiceImpl extends BaseServiceImpl<TbBrand> implements BrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public PageResult findPage(Integer pageNum, Integer rows) {
        return findByPage(pageNum,rows);
    }

    @Override
    public void save(TbBrand tbBrand) {
        add(tbBrand);
    }

    @Override
    public TbBrand findById(Long id) {
        return findOne(id);
    }

    @Override
    public void updateBrand(TbBrand tbBrand) {
        update(tbBrand);
    }

    @Override
    public void deleteBrands(Long[] ids) {
        deleteBatch(ids);
    }

    @Override
    public PageResult search(Integer pageNum, Integer rows, TbBrand tbBrand) {
        PageHelper.startPage(pageNum,rows);
        Example example = new Example(TbBrand.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(tbBrand.getName())){
            criteria.andLike("name","%" + tbBrand.getName() + "%");
        }
        if(!StringUtils.isEmpty(tbBrand.getFirstChar())){
            criteria.andLike("firstChar",tbBrand.getFirstChar());
        }
        List<TbBrand> brands = brandMapper.selectByExample(example);
        PageInfo<TbBrand> pageInfo = new PageInfo<>(brands);
        return new PageResult(pageInfo.getTotal(),brands);
    }


}
