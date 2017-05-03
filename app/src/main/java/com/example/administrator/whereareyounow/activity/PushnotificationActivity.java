package com.example.administrator.whereareyounow.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import com.example.administrator.whereareyounow.R;
import com.example.administrator.whereareyounow.adapter.PushnotificationAdapter;

import java.util.ArrayList;

public class PushnotificationActivity extends AppCompatActivity {
    private RecyclerView pushlist;
    private ArrayList<String> list;
    private PushnotificationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_pushnotification);
        pushlist= (RecyclerView) findViewById(R.id.push_notificate);
        //初始化数据
        list = new ArrayList<>();
        initDatas();
        initView();
        adapter = new PushnotificationAdapter(this, list);
        pushlist.setAdapter(adapter);
    }
    //对RecyclerView进行设置
    private void initView() {

        pushlist.setLayoutManager(new LinearLayoutManager(this));
//  rcv.setLayoutManager(new GridLayoutManager(getActivity(),2));//效果是网格的,3是3列
        // rcv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,true));//倒序排列
    }

    private void initDatas() {
        for (int i = 0; i < 6; i++) {
            list.add(i + "sss");
        }

    }
}
