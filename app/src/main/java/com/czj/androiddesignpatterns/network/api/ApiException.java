package com.czj.androiddesignpatterns.network.api;

public class ApiException extends RuntimeException{

    private int errorCode;
    public String message;

    public ApiException(int code,String msg){
        super(msg);
        errorCode = code;
        message = msg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
