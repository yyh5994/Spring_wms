package com.wms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.common.Result;
import com.wms.entity.Menu;
import com.wms.entity.User;
import com.wms.service.MenuService;
import com.wms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static org.apache.logging.log4j.util.Strings.isNotEmpty;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired private UserService userService;
    @Autowired private MenuService menuService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        List<User> list=userService.lambdaQuery().eq(
                User::getNo, user.getNo())
                .eq(User::getPassword, user.getPassword()).list();
        if (list.size()>0){
            User user1=list.get(0);
            List<Menu> menus=menuService.lambdaQuery().like(Menu::getMenuRight,user1.getRoleId()).list();
            HashMap<Object, Object> map=new HashMap<>();
            map.put("user",user1);
            map.put("menus",menus);
            return Result.success(map);
        }
        return Result.error();
    }

    @RequestMapping("/list")
    public List<User> list(){
        return userService.list();
    }
    //增加
    @PostMapping("/save")
    public Result save(@RequestBody User user){
        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getNo, user.getNo());
        User one = userService.getOne(queryWrapper);
        if (one ==null){
            userService.save(user);
            return Result.success();
        }else {
            return Result.error("该账号已存在！");
        }
    }
    //通过账号查询是否存在
    @GetMapping("/selectByNo")
    public Result selectByNo(@RequestParam String no){
        List list=userService.lambdaQuery().eq(User::getNo,no).list();
        return list.size()>0?Result.error("账号已存在"):Result.success();
    }
    //修改
    @PostMapping("/mod")
    public Result mod(@RequestBody User user){
        userService.updateById(user);
        return Result.success();
    }
    //新增或修改
    @PostMapping("/saveOrMod")
    public boolean saveOrMod(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }
    //删除
    @GetMapping("/delete")
    public Result delete(@RequestParam Integer id){
        boolean b = userService.removeById(id);
        return b? Result.success() : Result.error("删除失败！");
    }
    //查询（模糊）
    @PostMapping("/listP")
    public Result listP(@RequestBody User user){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        if (isNotEmpty(user.getName())){
            queryWrapper.like(User::getName,user.getName());
        }
        List<User> userList=userService.list(queryWrapper);
        return Result.success(userList);
    }
    @PostMapping("/listPage")
    public Result listP(@RequestBody QueryPageParam query){

        User user=query.getUser();

        Page<User> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        page.setMaxLimit(20L);

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();

        String name=user.getName();
        String no= user.getNo();
        Integer roleId=user.getRoleId();
        Integer sex=user.getSex();

        System.out.println(user.getRoleId());
        if (StringUtils.isNotBlank(name)&& !"null".equalsIgnoreCase(name)){
            queryWrapper.like(User::getName,name);
        }
        if (StringUtils.isNotBlank(no)&&!"null".equalsIgnoreCase(no)){
            queryWrapper.like(User::getNo,no);
        }
        if (roleId!=null){
            queryWrapper.eq(User::getRoleId,roleId);
        }
        if (sex!=null){
            queryWrapper.eq(User::getSex,sex);
        }
        Page<User> page1 = userService.page(page, queryWrapper);
        return Result.success(page1.getRecords(),page1.getTotal());
    }
}
