package com.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wms.entity.Goods;
import com.wms.service.GoodsService;
import com.wms.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

/**
* @author 1
* @description 针对表【goods】的数据库操作Service实现
* @createDate 2023-07-15 16:33:52
*/
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>
    implements GoodsService{

}




