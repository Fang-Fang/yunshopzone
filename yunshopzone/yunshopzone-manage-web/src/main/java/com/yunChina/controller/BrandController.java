package com.yunChina.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yunChina.pojo.TbBrand;
import com.yunChina.vo.PageResult;
import com.yunChina.vo.Result;
import com.yunChina.zonegoods.service.BrandService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;
import java.util.function.LongFunction;


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

    /**
     * 分页查找所有品牌
     * @param pageNum
     * @param rows
     * @return
     */
    @GetMapping("/findPage")
    public PageResult findPage(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "rows",defaultValue = "10") Integer rows){
        return brandService.findPage(pageNum,rows);
    }

    /**
     * 新增保存
     * @param tbBrand
     * @return
     */
    @PostMapping("/save")
    public Result save(@RequestBody TbBrand tbBrand){
        brandService.save(tbBrand);
        return Result.ok("保存成功！");
    }

    /**
     * 根据id查询一个品牌
     * @param id
     * @return
     */
    @GetMapping("/findById")
    public TbBrand findById(Long id){
        return brandService.findById(id);
    }
    /**
     * 编辑更新
     */
    @PostMapping("/update")
    public Result update(@RequestBody TbBrand tbBrand){
        brandService.updateBrand(tbBrand);
        return Result.ok("更新数据成功！");
    }

    /**
     * 删除商品
     */
    @GetMapping("/deleteBrands")
    public Result deleteBrands(Long[] ids){
        brandService.deleteBrands(ids);
        return Result.ok("删除成功！");
    }

    @PostMapping("/search")
    public PageResult search(@RequestBody TbBrand tbBrand,
                             @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "rows",defaultValue = "10") Integer rows){
        if (tbBrand == null){
            return brandService.findPage(pageNum,rows);
        }else {
            return brandService.search(pageNum,rows,tbBrand);
        }
    }

}
