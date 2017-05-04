package com.example.administrator.whereareyounow.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.whereareyounow.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_login, forgetpwd;
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
        setContentView(R.layout.activity_login);
        init();
        tv_login.setText("登录");

    }

    private void init() {
        tv_login = (TextView) findViewById(R.id.title_center);
        forgetpwd = (TextView) findViewById(R.id.forgetpwd);
        title_left = (ImageView) findViewById(R.id.title_left);
        forgetpwd.setOnClickListener(this);
        title_left.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.forgetpwd:
                startActivity(new Intent(this, ForgetpwdActivity.class));
                break;
            case R.id.title_left:
                finish();
                break;

        }

    }
}
