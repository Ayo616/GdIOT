package com.example.yan.myapplication.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yan.myapplication.Entity.ZhiHuNews;
import com.example.yan.myapplication.R;

import java.util.List;

/**
 * Created by yan on 2016/10/9.
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    private List<ZhiHuNews.StoriesBean> data = null;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener{
        void OnItemClick(View view,int postiton,int id);
    }

    public RecycleAdapter(List<ZhiHuNews.StoriesBean> data) {
        this.data = data;
    }

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycle,parent,false);
        ViewHolder vh = new ViewHolder(view);
        return  vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
           holder.mtextView.setText(data.get(position).getTitle());
        final int id = data.get(position).getId();
        if (mOnItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.OnItemClick(holder.itemView,position,id);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mtextView;
        public ViewHolder(View itemView) {
            super(itemView);
            mtextView= (TextView) itemView.findViewById(R.id.recycle_item);
        }
    }
}
