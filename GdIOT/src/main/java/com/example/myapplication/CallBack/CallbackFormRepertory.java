package com.example.myapplication.CallBack;

import com.example.myapplication.Entity.News;

/**
 * Created by yan on 2016/10/13.
 */
public interface CallbackFormRepertory {

    void OnSuccess(News news);
    void OnError(String string);
}
