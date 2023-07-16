package com.wms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.common.Result;
import com.wms.entity.Goods;
import com.wms.entity.Record;
import com.wms.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("record")
public class RecordController {
    @Autowired
    private RecordService recordService;
    @RequestMapping("/list")
    public Result list(){
        return Result.success(recordService.list());
    }
    //增加
    @PostMapping("/save")
    public Result save(@RequestBody Record record){
        Date now=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate =sdf.format(now);
        record.setCreatetime(formattedDate);
        recordService.save(record);
        return  Result.success();
    }
    //修改
    @PostMapping("/update")
    public Result mod(@RequestBody Record record){
        recordService.updateById(record);
        return Result.success();
    }
    //新增或修改
    @PostMapping("/saveOrMod")
    public boolean saveOrMod(@RequestBody Record record){
        return recordService.saveOrUpdate(record);
    }
    //删除
    @GetMapping("/del")
    public Result delete(@RequestParam Integer id){
        boolean b = recordService.removeById(id);
        return b? Result.success() : Result.error("删除失败！");
    }
    @PostMapping("/listPage")
    public Result listP(@RequestBody QueryPageParam query){
        Record record=query.getRecord();
        Page<Record> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        page.setMaxLimit(20L);

        LambdaQueryWrapper<Record> queryWrapper = new LambdaQueryWrapper<>();
//        String name=record.g();
//        if(StringUtils.isNotBlank(name)&&!"null".equalsIgnoreCase(name)){
//            queryWrapper.like(Goods::getName, name);
//        }


        Page<Record> page1 = recordService.page(page, queryWrapper);
        return Result.success(page1.getRecords(),page1.getTotal());
    }
}
