package com.example.yan.myapplication;

/**
 * Created by yan on 2016/9/30.
 */
public interface Contract {

    interface BasePresenter{
        void LoadData();
        void onSetTextView();
        //使用model层加载数据
        //使用view层展示数据
    }

   /////////////////////////////

    interface BaseView{
        void SetTextView(String data);
    }
}
