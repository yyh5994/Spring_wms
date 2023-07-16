package com.wms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.common.Result;
import com.wms.entity.Goods;
import com.wms.entity.Goodstype;
import com.wms.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @RequestMapping("/list")
    public Result list(){
        return Result.success(goodsService.list());
    }
    //增加
    @PostMapping("/save")
    public Result save(@RequestBody Goods goods){
        goodsService.save(goods);
        return  Result.success();
    }
    //修改
    @PostMapping("/update")
    public Result mod(@RequestBody Goods goods){
        goodsService.updateById(goods);
        return Result.success();
    }
    //新增或修改
    @PostMapping("/saveOrMod")
    public boolean saveOrMod(@RequestBody Goods goods){
        return goodsService.saveOrUpdate(goods);
    }
    //删除
    @GetMapping("/del")
    public Result delete(@RequestParam Integer id){
        boolean b = goodsService.removeById(id);
        return b? Result.success() : Result.error("删除失败！");
    }
    @PostMapping("/listPage")
    public Result listP(@RequestBody QueryPageParam query){
        Goods goods1=query.getGoods();
        Page<Goods> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        page.setMaxLimit(20L);

        LambdaQueryWrapper<Goods> queryWrapper = new LambdaQueryWrapper<>();
        String name=goods1.getName();
        if(StringUtils.isNotBlank(name)&&!"null".equalsIgnoreCase(name)){
            queryWrapper.like(Goods::getName, name);
        }


        Page<Goods> page1 = goodsService.page(page, queryWrapper);
        return Result.success(page1.getRecords(),page1.getTotal());
    }
}
