package com.example.yan.myapplication.retrofit;

import com.example.yan.myapplication.Entity.OneNews;
import com.example.yan.myapplication.Entity.ZhiHuNews;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by yan on 2016/9/30.
 * 请求库
 */
public interface RequestHub {
    @GET("users/Ayo616")
    Call<News> requestNews();

    @GET("20140509/4746986_145156378323_2.jpg")
    Observable<ResponseBody> rxretrofit();

    @GET("{id}")
    Observable<ResponseBody>  performGetBitmap(@Path("id") String id);

    @GET("api/4/news/latest")
    Observable<ZhiHuNews> performZhiHu();


    @GET("api/4/news/{id}")
    Observable<OneNews> performZhiHu2(@Path("id") int id);
}
