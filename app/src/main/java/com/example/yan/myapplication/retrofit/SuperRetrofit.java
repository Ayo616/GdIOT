package com.example.yan.myapplication.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yan on 2016/10/10.
 * 封装 Retrofit
 */
public class SuperRetrofit {

    private static Retrofit retrofit = null;
    private static RequestHub callhub = null;

    /*
    * 生成 Retrofit 实例
    * */
    public synchronized static Retrofit createRetrofit(String address) {

        retrofit = new Retrofit.Builder().baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

    /*
    * 创建 RequestHub 请求库
    * */
    public synchronized static RequestHub createCall() {

        callhub = retrofit.create(RequestHub.class);
        return callhub;
    }

}
