package com.wms.mapper;

import com.wms.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 1
* @description 针对表【goods】的数据库操作Mapper
* @createDate 2023-07-15 16:33:52
* @Entity com.wms.entity.Goods
*/
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

}




