package com.yunChina.mapper;

import com.yunChina.pojo.TbBrand;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Date:2018/6/25
 * Author: Fong.x
 * Desc:
 */
public interface BrandMapper extends Mapper<TbBrand> {
    List<TbBrand> queryAll();
}
