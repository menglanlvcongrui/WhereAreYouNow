package com.example.administrator.whereareyounow.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.whereareyounow.R;

import static android.view.View.GONE;
import static com.example.administrator.whereareyounow.R.id.title_left;

public class HelpPublishActivity extends AppCompatActivity {
    private TextView title_center;
    private TextView tv_title_right;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_publish);
        title_center= (TextView)findViewById(R.id.title_center);
        tv_title_right= (TextView)findViewById(R.id.title_right);
        title_center.setText("帮助信息");
        tv_title_right.setText("立即发布");
    }
}
