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

import com.example.administrator.whereareyounow.R;
import com.example.administrator.whereareyounow.adapter.DistanceAdapter;
import com.example.administrator.whereareyounow.adapter.TimeAdapter;

import java.util.ArrayList;


/*
public class DistanceFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_distance, container, false);
    }
}
*/
public class DistanceFragment extends Fragment {

    private RecyclerView rcv;
    private ArrayList<String> list;
    private DistanceAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_default, container, false);
        //初始化数据
        list = new ArrayList<>();
        initDatas();
        rcv = (RecyclerView) view.findViewById(R.id.rcv);
        initView();
        adapter = new DistanceAdapter(getContext(), list);
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
    }
}