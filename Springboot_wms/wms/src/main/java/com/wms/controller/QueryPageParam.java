package com.wms.controller;

import com.wms.entity.*;
import lombok.Data;

import javax.annotation.security.DenyAll;
import java.util.HashMap;

@Data
public class QueryPageParam {
    private static int PAGE_SIZE=20;
    private static int PAGE_NUM=1;


    private int pageSize=PAGE_SIZE;
    private int pageNum=PAGE_NUM;
    private User user =new User();
    private Storage storage =new Storage();
    private Goodstype goodstype=new Goodstype();
    private Goods goods=new Goods();
    private Record record=new Record();

}
