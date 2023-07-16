package com.wms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.common.Result;
import com.wms.entity.Storage;
import com.wms.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("storage")
public class StorageController {
    @Autowired
    private StorageService storageService;
    @RequestMapping("/list")
    public Result list(){
        return Result.success(storageService.list());
    }
    //增加
    @PostMapping("/save")
    public Result save(@RequestBody Storage storage){
        storageService.save(storage);
        return  Result.success();
    }
    //修改
    @PostMapping("/update")
    public Result mod(@RequestBody Storage storage){
        storageService.updateById(storage);
        return Result.success();
    }
    //新增或修改
    @PostMapping("/saveOrMod")
    public boolean saveOrMod(@RequestBody Storage storage){
        return storageService.saveOrUpdate(storage);
    }
    //删除
    @GetMapping("/del")
    public Result delete(@RequestParam Integer id){
        boolean b = storageService.removeById(id);
        return b? Result.success() : Result.error("删除失败！");
    }
    @PostMapping("/listPage")
    public Result listP(@RequestBody QueryPageParam query){
        Storage storage=query.getStorage();
        Page<Storage> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        page.setMaxLimit(20L);

        LambdaQueryWrapper<Storage> queryWrapper = new LambdaQueryWrapper<>();
        String name=storage.getName();
        if(StringUtils.isNotBlank(name)&&!"null".equalsIgnoreCase(name)){
            queryWrapper.like(Storage::getName, name);
        }


        Page<Storage> page1 = storageService.page(page, queryWrapper);
        return Result.success(page1.getRecords(),page1.getTotal());
    }
}
