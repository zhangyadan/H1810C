package com.example.mymode2.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mymode2.R;
import com.example.mymode2.beans.UserBeans;

import java.util.ArrayList;

/**
 * Created by 张亚丹 on 2019/5/29.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private ArrayList<UserBeans.DataBean.DatasBean> list;
    private Context context;

    public MyAdapter(ArrayList<UserBeans.DataBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserBeans.DataBean.DatasBean datasBean = list.get(position);
        holder.tv_title.setText(datasBean.getAuthor());
        Glide.with(context).load(datasBean.getEnvelopePic()).apply(new RequestOptions().circleCrop()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_title;
        private ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            img = itemView.findViewById(R.id.img);
        }
    }
}
