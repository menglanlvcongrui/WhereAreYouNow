package com.example.administrator.whereareyounow.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.whereareyounow.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-05-03.
 */

/*
public class DefaultAdapter {
}
*/
public class DefaultAdapter extends RecyclerView.Adapter<DefaultAdapter.ViewHolder> {
    private Context mcontext;
    private ArrayList<String> list;
    public DefaultAdapter(Context context, ArrayList<String> list) {
        this.mcontext = context;
        this.list = list;
    }
    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_help,viewGroup,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
//        viewHolder.mTextView.setText(list.get()position]);
    }
    //获取数据的数量
    @Override
    public int getItemCount() {
        return list.size();
    }
    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ViewHolder(View view){
            super(view);
//            mTextView = (TextView) view.findViewById(R.id.text);
        }
    }
}