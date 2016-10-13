package com.example.yan.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yan.myapplication.Activity.ContentActivity;
import com.example.yan.myapplication.Adapter.AdapterHub;
import com.example.yan.myapplication.Adapter.RecycleAdapter;
import com.example.yan.myapplication.Entity.ZhiHuNews;
import com.example.yan.myapplication.retrofit.News;
import com.example.yan.myapplication.retrofit.RequestHub;

import java.util.List;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity implements Contract.BaseView,
        View.OnClickListener,
        RecycleAdapter.OnItemClickListener {

    //定义控件
    private TextView textView;
    private Button button;
    private ImageView imageView;
    private RecyclerView recyclerView;
    //presenter
    private Contract.BasePresenter mpresenter;

    AdapterHub adapterHub;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.imageview);
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        button.setOnClickListener(this);
        //presenter
       // mpresenter = new MainPer(this);
        //mpresenter.LoadData();

//        RxDemo rxDemo = new RxDemo();
//        rxDemo.test();
//        Logger.d("执行完毕");

        String[] data ={"X","b","v","b","a"};
         adapterHub = new AdapterHub();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(adapterHub.getLayoutManager(this));
    }

    // 显示
    @Override
    public void SetTextView(String data) {
        textView.setText(data);
    }


    @Override
    public void onClick(View v) {
       // mpresenter.LoadData();
/*
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        RequestHub hub = retrofit.create(RequestHub.class);

        hub.rxretrofit()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<News>() {
                    @Override
                    public void call(News news) {
                        textView.setText(news.getEmail());
                        Toast.makeText(getApplicationContext(),"加载中",Toast.LENGTH_SHORT).show();
                    }
                });*/

        //////////////////////

/*        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl("http://pic41.nipic.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        RequestHub hub2 = retrofit2.create(RequestHub.class);

        hub2.rxretrofit()
                .map(new Func1<ResponseBody, Bitmap>() {
                    @Override
                    public Bitmap call(ResponseBody responseBody) {
                        return BitmapFactory.decodeStream(responseBody.byteStream());
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Bitmap>() {
                    @Override
                    public void call(Bitmap bitmap) {
                        imageView.setImageBitmap(bitmap);
                    }
                });*/

        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl("http://news-at.zhihu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        RequestHub hub2 = retrofit2.create(RequestHub.class);

        hub2.performZhiHu()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ZhiHuNews>() {
                    @Override
                    public void call(ZhiHuNews zhiHuNews) {
                        List<ZhiHuNews.StoriesBean> data = zhiHuNews.getStories();
                        RecycleAdapter recycleAdapter = adapterHub.getRecycleAdapter(data);
                        recycleAdapter.setmOnItemClickListener(MainActivity.this);
                        recyclerView.setAdapter(recycleAdapter);


                    }
                });





    }

    @Override
    public void OnItemClick(View view, int postiton,int id) {
        Toast.makeText(this,"you click me",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,ContentActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }
}
