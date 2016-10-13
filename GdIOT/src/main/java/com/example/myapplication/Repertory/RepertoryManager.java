package com.example.myapplication.Repertory;

import com.example.myapplication.CallBack.CallbackFormRepertory;
import com.example.myapplication.Entity.News;
import com.example.myapplication.Infomatic.INFO;
import com.example.myapplication.Retrofit.RequestHub;
import com.example.myapplication.Retrofit.RetrofitManager;

import retrofit2.Retrofit;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by yan on 2016/10/13.
 */
public class RepertoryManager {

    private IRepertory mRepertory;
    private CallbackFormRepertory callbackFormRepertory;

    public RepertoryManager(CallbackFormRepertory callbackFormRepertory) {
        this.callbackFormRepertory = callbackFormRepertory;
    }

    public void setmRepertory(IRepertory mRepertory) {
        this.mRepertory = mRepertory;
    }

    public void setCallbackFormRepertory(CallbackFormRepertory callbackFormRepertory) {
        this.callbackFormRepertory = callbackFormRepertory;
    }

    public void updateRepertory(){

        if (mRepertory==null)
        PerformRequest();
        else
            mRepertory.RequestFromNetwork(); //自定义请求

    }

    //默认请求
    public void PerformRequest(){
        RetrofitManager.buildRetrofit(INFO.ADDRESS).create(RequestHub.class)
                .callJson()
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<News>() {
                    @Override
                    public void call(News s) {
                        callbackFormRepertory.OnSuccess(s);
                    }
                });
    }


}
