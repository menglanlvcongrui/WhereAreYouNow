package com.example.administrator.whereareyounow.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.whereareyounow.R;

public class LoginActivity extends AppCompatActivity {
    private TextView  tv_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tv_login= (TextView) findViewById(R.id.title_center);
        tv_login.setText("登录");

    }
}
