package com.yunChina.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yunChina.pojo.TbBrand;
import com.yunChina.zonegoods.service.BrandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Date:2018/6/25
 * Author: Fong.x
 * Desc:
 */
@RequestMapping("/brand")
@RestController
public class BrandController {

    @Reference
    private BrandService brandService;

    @GetMapping("/findAll")
    public List<TbBrand> findAll() {
        return brandService.findAll();
    }


}
