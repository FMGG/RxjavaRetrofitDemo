package com.czj.androiddesignpatterns.network;


import com.czj.androiddesignpatterns.utils.LogUtil;

public class LogInterceptor implements HttpLoggingInterceptor.Logger {

    public static String INTERCEPTOR_TAG_STR = "OkHttp";

    public LogInterceptor() {
    }

    public LogInterceptor(String tag) {
        INTERCEPTOR_TAG_STR = tag;
    }

    @Override
    public void log(String message, @LogUtil.LogType int type) {
        LogUtil.printLog(false, type, INTERCEPTOR_TAG_STR, message);
    }
}
