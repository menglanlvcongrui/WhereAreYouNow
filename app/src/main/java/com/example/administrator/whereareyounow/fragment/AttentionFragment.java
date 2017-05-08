package com.example.administrator.whereareyounow.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.whereareyounow.R;
import com.example.administrator.whereareyounow.activity.InformationDetailsActivity;
import com.example.administrator.whereareyounow.adapter.AttentionAdapter;
import com.example.administrator.whereareyounow.adapter.DefaultAdapter;
import com.lfq.pulltorefresh.library.PullToRefreshBase;
import com.lfq.pulltorefresh.library.PullToRefreshRecyclerView;

import java.util.ArrayList;


/*
public class AttentionFragment extends Fragment implements View.OnClickListener {
    private ImageView title_left;
    private ImageView title_right1;
    private TextView title_center;
    private LinearLayout line1,line2,line3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_attention, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title_left= (ImageView) view.findViewById(R.id.title_left);
        title_center= (TextView) view.findViewById(R.id.title_center);
        title_right1= (ImageView) view.findViewById(R.id.title_right1);
        line1= (LinearLayout) view.findViewById(R.id.line1);
        line2= (LinearLayout) view.findViewById(R.id.line2);
        line3= (LinearLayout) view.findViewById(R.id.line3);
        line1.setOnClickListener(this);
        line2.setOnClickListener(this);
        line3.setOnClickListener(this);
        title_left.setVisibility(view.GONE);
        title_center.setText("我的关注");

    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch(v.getId()){
            case R.id.line1:
                intent.setClass(getContext(), InformationDetailsActivity.class);
               break;
            case R.id.line2:
                intent.setClass(getContext(), InformationDetailsActivity.class);
                break;
            case R.id.line3:
                intent.setClass(getContext(), InformationDetailsActivity.class);
                break;

        }
        startActivity(intent);
    }
}
*/
public class AttentionFragment extends Fragment {

    private PullToRefreshRecyclerView rcv;
    private ArrayList<String> list;
    private RecyclerView recyclerView;
    private AttentionAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_attention, container, false);
        //初始化数据
        list = new ArrayList<>();
        initDatas();
        rcv = (PullToRefreshRecyclerView) view.findViewById(R.id.rcv);
        recyclerView= rcv.getRefreshableView();
        initView();
        adapter = new AttentionAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);
        rcv.setMode(PullToRefreshBase.Mode.BOTH);
        rcv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<RecyclerView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                // 下拉刷新监听
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
//                                    list.clear();
//                                    DataModel.initData(list, "RecyclerView");
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText(getActivity(), "刷新成功", Toast.LENGTH_SHORT).show();
                                    rcv.onRefreshComplete();
                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }).start();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                // 上拉加载监听
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
//                                    DataModel.initData(list, "RecyclerView");
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText(getActivity(), "加载成功", Toast.LENGTH_SHORT).show();
                                    rcv.onRefreshComplete();
                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }).start();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void initDatas() {

        for (int i = 0; i < 6; i++) {
            list.add(i + "sss");
        }

    }

    //对RecyclerView进行设置
    private void initView() {

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//  rcv.setLayoutManager(new GridLayoutManager(getActivity(),2));//效果是网格的,3是3列
        // rcv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,true));//倒序排列
    }
}