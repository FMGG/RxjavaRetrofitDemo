package com.czj.androiddesignpatterns.network;

import com.czj.androiddesignpatterns.BuildConfig;
import com.czj.androiddesignpatterns.model.Constant;
import com.czj.androiddesignpatterns.network.api.ApiService;
import com.czj.androiddesignpatterns.network.factory.MyGsonConverterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestManager {

    private static RequestManager mInstance;
    private Retrofit mRetrofit = null;
    private OkHttpClient mOkHttpClient;
    private static int DEFAULT_TIMEOUT = 10;

    public static RequestManager getInstance() {
        if (mInstance == null) {
            synchronized (RequestManager.class) {
                if (mInstance == null) {
                    mInstance = new RequestManager();
                }
            }
        }
        return mInstance;
    }

    public void setOkHttpClient(OkHttpClient okHttpClient) {
        mOkHttpClient = okHttpClient;
    }

    public Retrofit getRetrofit() {
        if (mRetrofit == null) {
            synchronized (RequestManager.class) {
                if (mRetrofit == null) {

                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new LogInterceptor());
                    if (BuildConfig.DEBUG) {
                        //显示日志
                        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    } else {
                        interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
                    }

                    OkHttpClient okHttpClient = mOkHttpClient == null ? new OkHttpClient.Builder()
                            .readTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
                            .writeTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
                            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                            .retryOnConnectionFailure(true)
                            .addInterceptor(interceptor)
                            .addInterceptor(new HeaderInterceptor())
                            .build()
                            : mOkHttpClient;

                    mRetrofit = new Retrofit.Builder()
                            .baseUrl(Constant.REQUEST_URL)
                            .addConverterFactory(MyGsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(okHttpClient)
                            .build();
                }
            }
        }
        return mRetrofit;
    }

    public ApiService getRequestService() {
        return getRetrofit().create(ApiService.class);
    }

}
