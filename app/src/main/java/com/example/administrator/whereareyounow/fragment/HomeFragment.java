package com.example.administrator.whereareyounow.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.example.administrator.whereareyounow.R;
import com.example.administrator.whereareyounow.activity.PublishInformationActivity;
import com.example.administrator.whereareyounow.adapter.HomedefaultAdapter;

import java.util.ArrayList;


/*
public class HomeFragment extends Fragment {

    private RecyclerView rcv;
    private ArrayList<String> list;
    private HomedefaultAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //初始化数据
        list = new ArrayList<>();
        initDatas();
        rcv = (RecyclerView) view.findViewById(R.id.rcv);
        initView();
        adapter = new HomedefaultAdapter(getContext(), list);
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
*/
public class HomeFragment extends Fragment {
    private ImageView iv_title_left;
    private ImageView iv_title_right;
    private LinearLayout linearLayout;
    private RadioGroup radioGroup;
    private FragmentManager fm;
    private FragmentTransaction ft;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linearLayout=(LinearLayout)view.findViewById(R.id.content);
        radioGroup= (RadioGroup)view.findViewById(R.id.rg);
        iv_title_left= (ImageView) view.findViewById(R.id.title_left);
        iv_title_right= (ImageView) view.findViewById(R.id.title_right1);
        iv_title_left.setVisibility(view.GONE);
        iv_title_right.setVisibility(view.VISIBLE);
        iv_title_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getContext(), PublishInformationActivity.class);
                startActivity(intent);
            }
        });
        fm = getFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.content, new HomeDefaultFragment());
        ft.commit();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ft = fm.beginTransaction();
                switch(checkedId){
                    case R.id.button:
                        ft.replace(R.id.content, new HomeDefaultFragment());
                        break;
                    case R.id.button1:
                        ft.replace(R.id.content, new HomeTimeFragment());
                        break;
                    case R.id.button2:
                        ft.replace(R.id.content, new HomeDistanceFragment());
                        break;
                    default:
                        break;
                }
                ft.commit();
            }
        });
    }
}
