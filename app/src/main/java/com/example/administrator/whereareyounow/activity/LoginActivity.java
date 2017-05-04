package com.example.administrator.whereareyounow.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.administrator.whereareyounow.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView  tv_login,forgetpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_login);
        tv_login= (TextView) findViewById(R.id.title_center);
        forgetpwd= (TextView) findViewById(R.id.forgetpwd);
        forgetpwd.setOnClickListener(this);
        tv_login.setText("登录");

    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this,ForgetpwdActivity.class));
    }
}
