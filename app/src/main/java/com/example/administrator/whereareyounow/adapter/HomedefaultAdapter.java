package com.example.administrator.whereareyounow.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.whereareyounow.R;
import com.example.administrator.whereareyounow.activity.ChatActivity;

import java.util.ArrayList;

/**
 * Created by GX on 2017/5/2 0002.
 */

public class HomedefaultAdapter extends RecyclerView.Adapter<HomedefaultAdapter.ViewHolder> {
    private Context mcontext;
    private ArrayList<String> list;
    public HomedefaultAdapter(Context context, ArrayList<String> list) {
        this.mcontext = context;
        this.list = list;
    }
    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_default_list,viewGroup,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mcontext, ChatActivity.class);
                mcontext.startActivity(intent);
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
        ImageView chat;

        public ViewHolder(View view) {
            super(view);
            chat = (ImageView) view.findViewById(R.id.chat);
//            mTextView = (TextView) view.findViewById(R.id.text);
        }
    }
}
