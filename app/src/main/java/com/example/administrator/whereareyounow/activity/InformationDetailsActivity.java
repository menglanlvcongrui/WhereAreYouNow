package com.example.administrator.whereareyounow.activity;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.whereareyounow.R;

public class InformationDetailsActivity extends AppCompatActivity {
    private ImageView iv_title_left;
    private TextView tv_title_center;
    private ImageView iv_title_right;
    private ImageView iv_left;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_information_details);
        iv_title_left= (ImageView)findViewById(R.id.title_left);
        tv_title_center= (TextView)findViewById(R.id.title_center);
        iv_left= (ImageView) findViewById(R.id.iv_left);
        iv_title_right= (ImageView) findViewById(R.id.title_right1);
        iv_title_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_title_center.setText("信息详情");
        iv_left.setVisibility(View.VISIBLE);
        iv_left.setImageResource(R.drawable.chat_white);
        iv_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(InformationDetailsActivity.this,ChatActivity.class);
                startActivity(intent);
            }
        });
        iv_title_right.setVisibility(View.VISIBLE);
        iv_title_right.setImageResource(R.drawable.release_white);
    }
}
