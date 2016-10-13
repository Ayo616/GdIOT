package com.example.yan.myapplication.Adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yan.myapplication.Entity.ZhiHuNews;

import java.util.List;

/**
 * Created by yan on 2016/10/9.
 */
public class AdapterHub {
    private RecycleAdapter recycleAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public RecycleAdapter getRecycleAdapter(List<ZhiHuNews.StoriesBean> data) {
        return new RecycleAdapter(data);
    }

    public RecyclerView.LayoutManager getLayoutManager(Context context) {
        return new LinearLayoutManager(context);
    }
}
