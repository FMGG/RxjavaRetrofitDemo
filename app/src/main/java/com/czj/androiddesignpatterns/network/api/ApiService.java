package com.czj.androiddesignpatterns.network.api;


import com.czj.androiddesignpatterns.network.Weather;
import com.czj.androiddesignpatterns.responseBean.AddressListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("weather/current/{city}")
    Observable<Weather> getWeather(@Path("city") String city);

    @GET("address/list")
    Observable<AddressListBean> getAddressList();

}
