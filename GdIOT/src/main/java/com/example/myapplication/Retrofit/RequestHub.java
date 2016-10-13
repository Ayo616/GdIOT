package com.example.myapplication.Retrofit;

import com.example.myapplication.Entity.News;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by yan on 2016/10/13.
 */
public interface RequestHub {

    @GET("")
    Observable<News> callJson();

}
