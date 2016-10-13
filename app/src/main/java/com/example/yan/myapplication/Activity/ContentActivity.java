package com.example.yan.myapplication.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.example.yan.myapplication.Entity.OneNews;
import com.example.yan.myapplication.Entity.ZhiHuNews;
import com.example.yan.myapplication.R;
import com.example.yan.myapplication.retrofit.RequestHub;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class ContentActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        textView = (TextView) findViewById(R.id.content_news);
        int id = getIntent().getIntExtra("id", 0);

        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl("http://news-at.zhihu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        RequestHub hub2 = retrofit2.create(RequestHub.class);

        hub2.performZhiHu2(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<OneNews>() {
                    @Override
                    public void call(OneNews oneNews) {
                        String data = String.valueOf(Html.fromHtml(oneNews.getBody()));
                        textView.setText(data);
                    }
                });
    }

}
