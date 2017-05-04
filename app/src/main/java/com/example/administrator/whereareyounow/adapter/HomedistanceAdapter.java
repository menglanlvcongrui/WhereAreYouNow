package com.example.administrator.whereareyounow.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.whereareyounow.R;
import com.example.administrator.whereareyounow.activity.ChatActivity;
import com.example.administrator.whereareyounow.activity.InformationDetailsActivity;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-05-03.
 */

/*
public class HomedistanceAdapter {
}
*/
public class HomedistanceAdapter extends RecyclerView.Adapter<HomedistanceAdapter.ViewHolder> {
    private Context mcontext;
    private ArrayList<String> list;

    public HomedistanceAdapter(Context context, ArrayList<String> list) {
        this.mcontext = context;
        this.list = list;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_default_list, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
//        viewHolder.mTextView.setText(list.get()position]);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent();
                intent4.setClass(mcontext, InformationDetailsActivity.class);
                mcontext.startActivity(intent4);
            }
        });

        viewHolder.iv_distance_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent();
                intent5.setClass(mcontext, ChatActivity.class);
                mcontext.startActivity(intent5);
            }
        });
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return list.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ImageView iv_distance_chat;
        public ViewHolder(View view) {
            super(view);
//            mTextView = (TextView) view.findViewById(R.id.text);
           iv_distance_chat= (ImageView) view.findViewById(R.id.chat);
        }
    }
}
