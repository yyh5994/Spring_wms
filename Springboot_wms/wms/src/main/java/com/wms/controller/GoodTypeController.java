package com.wms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.common.Result;
import com.wms.entity.Goodstype;
import com.wms.entity.Storage;
import com.wms.service.GoodstypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("goodsType")
public class GoodTypeController {
    @Autowired
    private GoodstypeService goodstypeService;
    @RequestMapping("/list")
    public Result list(){
        return Result.success(goodstypeService.list());
    }
    //增加
    @PostMapping("/save")
    public Result save(@RequestBody Goodstype goodstype){
        goodstypeService.save(goodstype);
        return  Result.success();
    }
    //修改
    @PostMapping("/update")
    public Result mod(@RequestBody Goodstype goodstype){
        goodstypeService.updateById(goodstype);
        return Result.success();
    }
    //新增或修改
    @PostMapping("/saveOrMod")
    public boolean saveOrMod(@RequestBody Goodstype goodstype){
        return goodstypeService.saveOrUpdate(goodstype);
    }
    //删除
    @GetMapping("/del")
    public Result delete(@RequestParam Integer id){
        boolean b = goodstypeService.removeById(id);
        return b? Result.success() : Result.error("删除失败！");
    }
    @PostMapping("/listPage")
    public Result listP(@RequestBody QueryPageParam query){
        Goodstype goodstype=query.getGoodstype();
        Page<Goodstype> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        page.setMaxLimit(20L);

        LambdaQueryWrapper<Goodstype> queryWrapper = new LambdaQueryWrapper<>();
        String name=goodstype.getName();
        if(StringUtils.isNotBlank(name)&&!"null".equalsIgnoreCase(name)){
            queryWrapper.like(Goodstype::getName, name);
        }


        Page<Goodstype> page1 = goodstypeService.page(page, queryWrapper);
        return Result.success(page1.getRecords(),page1.getTotal());
    }
}
