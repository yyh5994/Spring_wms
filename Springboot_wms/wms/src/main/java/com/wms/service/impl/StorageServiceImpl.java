package com.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wms.entity.Storage;
import com.wms.service.StorageService;
import com.wms.mapper.StorageMapper;
import org.springframework.stereotype.Service;

/**
* @author 1
* @description 针对表【storage】的数据库操作Service实现
* @createDate 2023-07-15 16:33:52
*/
@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage>
    implements StorageService{

}




