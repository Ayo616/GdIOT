package com.example.yan.myapplication;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.yan.myapplication.retrofit.News;
import com.example.yan.myapplication.retrofit.RequestHub;
import com.orhanobut.logger.Logger;

import java.io.IOException;


import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.widget.Toast.LENGTH_LONG;

/**
 * Created by yan on 2016/9/30.
 */
public class MainPer implements Contract.BasePresenter {

    private Contract.BaseView view;
    private String data;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Log.d("handler",msg.obj.toString());
            view.SetTextView(msg.obj.toString());
        }
    };

    public MainPer(Contract.BaseView view){
        this.view = view;
    }
    @Override
    public void LoadData(){
        final Repertory repertory = new Repertory();
        new Thread(new Runnable() {
            @Override
            public void run() {
                data = "";
                        //repertory.getData();
                Log.d("data",data);
                Message message = Message.obtain();
                message.obj = data;
                handler.sendMessage(message);
            }
        }).start();
    }


    @Override
    public void onSetTextView() {
        view.SetTextView(data);
    }
}
