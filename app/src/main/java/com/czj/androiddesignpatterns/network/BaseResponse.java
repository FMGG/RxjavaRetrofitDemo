package com.czj.androiddesignpatterns.network;

public class BaseResponse {

    //基类字段需要自己根据后台返回的json数据 自己定义
    //字段名更改后需要同步更改自定义GsonResponseBodyConverter 中的 BaseResponse.get
    private String msg;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}