package com.wms.common;

import lombok.Data;

@Data
public class Result {
    private int code;//200success 400error
    private String msg;//成功失败
    private Long total;//总条数
    private Object data;
    public static Result error(){
        return result(400,"失败",0L,null);
    }
    public static Result error(String msg){
        return result(400,msg,0L,null);
    }

    public static Result success(){
        return result(200,"成功",0L,null);
    }
    public static Result success(Object data){
        return result(200,"成功",0L,data);
    }
    public static Result success(Object data,Long total){
        return result(200,"成功",total,data);
    }

    public static Result result(int code,String msg,Long total,Object object){
        Result r=new Result();
        r.code=code;
        r.msg=msg;
        r.total=total;
        r.data=object;
        return r;
    }
}
