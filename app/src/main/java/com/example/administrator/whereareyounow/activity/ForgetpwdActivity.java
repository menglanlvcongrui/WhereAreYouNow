package com.example.administrator.whereareyounow.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.whereareyounow.R;

public class ForgetpwdActivity extends AppCompatActivity implements View.OnClickListener {
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
        setContentView(R.layout.activity_forgetpwd);
        tv_title_center = (TextView) findViewById(R.id.title_center);
        tv_title_center.setText("忘记密码");
        title_left = (ImageView) findViewById(R.id.title_left);
        title_left.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
