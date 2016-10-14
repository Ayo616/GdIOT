package com.example.myapplication.Adapter;

import android.app.FragmentBreadCrumbs;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.myapplication.R;

import java.util.List;
import java.util.logging.ConsoleHandler;

/**
 * Created by yan on 2016/10/14.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyHolder> {

    //数据源
    private List list;
    //监听器
    private OnItemClickListener mOnItemClickListener;

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载item布局
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycleview,parent,false);
        //构造holder并返回
        MyHolder vh = new MyHolder(view);
        return  vh;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        //刷新数据和监听反馈
        holder.textView.setText("");
        if (mOnItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.OnItemClick(holder.itemView,position,0);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        //得到长度
        return list.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder{

        //item中的控件
        private TextView textView;
        private ImageView imageView;

        public MyHolder(View itemView) {
            super(itemView);
            //findbyid here

        }


    }

}
