package com.example.administrator.whereareyounow.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.whereareyounow.R;

public class SigninActivity extends AppCompatActivity {
    private TextView tv_title_center;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        tv_title_center= (TextView)findViewById(R.id.title_center);
        tv_title_center.setText("注册");
    }
}
