package com.czj.androiddesignpatterns.network.api;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.text.ParseException;

import retrofit2.HttpException;

public class ApiErrorHelper {

    public static ApiException handleCommonError(Context context,Throwable e){
        ApiException exception;
        if (e instanceof HttpException){
            HttpException httpException = (HttpException) e;
            exception = new ApiException(ApiCode.HTTP_ERROR,httpException.message());
            exception.message = "网络错误";
        }else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException){
            exception = new ApiException(ApiCode.PARSE_ERROR,e.getMessage());
            exception.message = "解析错误";
        }else if (e instanceof  ApiException){
            exception = (ApiException) e;
        }else {
            exception = new ApiException(ApiCode.UNKNOWN,e.getMessage());
            exception.message = "未知错误";
        }
        Toast.makeText(context,exception.message,Toast.LENGTH_SHORT).show();
        return exception;
    }


}
