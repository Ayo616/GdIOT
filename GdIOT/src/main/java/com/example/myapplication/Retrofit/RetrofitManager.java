package com.example.myapplication.Retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yan on 2016/10/13.
 */
public class RetrofitManager {

    private static Retrofit retrofit;

    public synchronized static Retrofit buildRetrofit(String address){
        retrofit = new Retrofit.Builder()
                .baseUrl(address)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }


}
