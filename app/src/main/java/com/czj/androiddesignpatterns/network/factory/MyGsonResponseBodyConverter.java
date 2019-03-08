package com.czj.androiddesignpatterns.network.factory;


import com.czj.androiddesignpatterns.network.api.ApiCode;
import com.czj.androiddesignpatterns.network.BaseResponse;
import com.czj.androiddesignpatterns.network.api.ApiException;
import com.czj.androiddesignpatterns.utils.LogUtil;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.StringReader;

import io.reactivex.annotations.Nullable;
import okhttp3.ResponseBody;
import retrofit2.Converter;

public class MyGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Gson mGson;
    private final TypeAdapter<T> mAdapter;

    public MyGsonResponseBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        mGson = gson;
        mAdapter = typeAdapter;
    }


    @Nullable
    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        BaseResponse baseResponse = mGson.fromJson(response, BaseResponse.class);
        //自定义响应码中不等于成功 抛出异常
        if (baseResponse.getCode() != ApiCode.SUCCESS) {
            value.close();
            throw new ApiException(baseResponse.getCode(),baseResponse.getMsg());
        }

        JsonReader jsonReader = mGson.newJsonReader(new StringReader(response));
        jsonReader.setLenient(true);

        try {
            return mAdapter.read(jsonReader);
        }finally {
            value.close();
        }
    }

}
