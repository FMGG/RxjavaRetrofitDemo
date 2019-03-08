package com.czj.androiddesignpatterns.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request requestBuilder = request.newBuilder()
                .build();
        return chain.proceed(requestBuilder);
    }

}
