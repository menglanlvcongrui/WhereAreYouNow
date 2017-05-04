package com.example.administrator.whereareyounow.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.whereareyounow.R;

public class PublishInformationActivity extends AppCompatActivity {
    private TextView tv_title_center;
    private TextView tv_title_right;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_information);
        tv_title_center= (TextView)findViewById(R.id.title_center);
        tv_title_right= (TextView)findViewById(R.id.title_right);
        tv_title_center.setText("帮助信息");
        tv_title_right.setText("立即发布");
    }
}
