package com.example.myapplication.Presenter;

import android.view.View;

import com.example.myapplication.CallBack.CallbackFormRepertory;
import com.example.myapplication.Entity.News;
import com.example.myapplication.Repertory.RepertoryManager;
import com.example.myapplication.Retrofit.RetrofitManager;

/**
 * Created by yan on 2016/10/13.
 */
public class MainAcitivyPresenter implements CallbackFormRepertory {
    private RepertoryManager manager;
    private View view;

    public void OnLoadingData(){
        manager = new RepertoryManager(this);
        manager.updateRepertory();
    }

    @Override
    public void OnSuccess(News news) {

    }

    @Override
    public void OnError(String string) {

    }
}
