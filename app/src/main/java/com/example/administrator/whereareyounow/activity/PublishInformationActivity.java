package com.example.administrator.whereareyounow.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.whereareyounow.R;

public class PublishInformationActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_title_center;
    private TextView tv_title_right;
    private ImageView title_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_information);
        init();
        tv_title_center.setText("发布信息");
        tv_title_right.setText("立即发布");
    }

    private void init() {
        tv_title_center = (TextView) findViewById(R.id.title_center);
        tv_title_right = (TextView) findViewById(R.id.title_right);
        title_left = (ImageView) findViewById(R.id.title_left);
        title_left.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
