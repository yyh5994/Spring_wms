package com.wms.mapper;

import com.wms.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
* @author 1
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-07-12 11:38:27
* @Entity com.wms.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




