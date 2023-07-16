package com.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wms.entity.Record;
import com.wms.service.RecordService;
import com.wms.mapper.RecordMapper;
import org.springframework.stereotype.Service;

/**
* @author 1
* @description 针对表【record】的数据库操作Service实现
* @createDate 2023-07-15 16:33:52
*/
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record>
    implements RecordService{

}




