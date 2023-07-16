package com.wms.service;

import com.wms.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 1
* @description 针对表【user】的数据库操作Service
* @createDate 2023-07-12 11:38:27
*/
public interface UserService extends IService<User> {
    List<User> findAll();
}
