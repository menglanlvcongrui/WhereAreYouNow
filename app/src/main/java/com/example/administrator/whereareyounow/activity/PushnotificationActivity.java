package com.example.administrator.whereareyounow.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.whereareyounow.R;
import com.example.administrator.whereareyounow.adapter.PushnotificationAdapter;

import java.util.ArrayList;

public class PushnotificationActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView pushlist;
    private ArrayList<String> list;
    private PushnotificationAdapter adapter;
    private TextView tv_title_center;
    private ImageView title_left;

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

        //初始化数据
        list = new ArrayList<>();
        initDatas();
        initView();
        adapter = new PushnotificationAdapter(this, list);
        pushlist.setAdapter(adapter);
        tv_title_center.setText("通知");
    }

    //对RecyclerView进行设置
    private void initView() {
        pushlist = (RecyclerView) findViewById(R.id.push_notificate);
        tv_title_center = (TextView) findViewById(R.id.title_center);
        title_left=(ImageView)findViewById(R.id.title_left);
        title_left.setOnClickListener(this);
        pushlist.setLayoutManager(new LinearLayoutManager(this));
        //  rcv.setLayoutManager(new GridLayoutManager(getActivity(),2));//效果是网格的,3是3列
        // rcv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,true));//倒序排列
    }

    @Override
    public void onClick(View view) {
        finish();
    }

    private void initDatas() {
        for (int i = 0; i < 6; i++) {
            list.add(i + "sss");
        }

    }
}
