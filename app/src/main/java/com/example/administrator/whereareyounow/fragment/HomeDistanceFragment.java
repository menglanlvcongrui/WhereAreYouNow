package com.example.administrator.whereareyounow.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.whereareyounow.R;
import com.example.administrator.whereareyounow.adapter.HomedefaultAdapter;
import com.example.administrator.whereareyounow.adapter.HomedistanceAdapter;
import com.lfq.pulltorefresh.library.PullToRefreshBase;
import com.lfq.pulltorefresh.library.PullToRefreshRecyclerView;

import java.util.ArrayList;


/*public class HomeDistanceFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_distance, container, false);
    }
}*/
public class HomeDistanceFragment extends Fragment {

    /*private RecyclerView rcv;
    private ArrayList<String> list;
    private HomedistanceAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_distance, container, false);
        //初始化数据
        list = new ArrayList<>();
        initDatas();
        rcv = (RecyclerView) view.findViewById(R.id.rcv);
        initView();
        adapter = new HomedistanceAdapter(getContext(), list);
        rcv.setAdapter(adapter);

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

        rcv.setLayoutManager(new LinearLayoutManager(getActivity()));
//  rcv.setLayoutManager(new GridLayoutManager(getActivity(),2));//效果是网格的,3是3列
        // rcv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,true));//倒序排列
    }*/
    private PullToRefreshRecyclerView rcv;
    private ArrayList<String> list;
    private RecyclerView recyclerView;
    private HomedistanceAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_distance, container, false);
        //初始化数据
        list = new ArrayList<>();
        initDatas();
        rcv = (PullToRefreshRecyclerView) view.findViewById(R.id.rcv);
        recyclerView= rcv.getRefreshableView();
        initView();
        adapter = new HomedistanceAdapter(getContext(), list);
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
