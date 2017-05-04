package com.example.administrator.whereareyounow.activity;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.administrator.whereareyounow.R;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv_title_center,agreement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_signin);
        tv_title_center= (TextView)findViewById(R.id.title_center);
        agreement= (TextView) findViewById(R.id.agreement);
        agreement.setOnClickListener(this);
        tv_title_center.setText("注册");
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this,UseragreementActivity.class));
    }
}
