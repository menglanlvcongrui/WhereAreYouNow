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

public class SigninActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_title_center, agreement;
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
        setContentView(R.layout.activity_signin);
        init();

        tv_title_center.setText("注册");
    }

    private void init() {
        tv_title_center = (TextView) findViewById(R.id.title_center);
        agreement = (TextView) findViewById(R.id.agreement);
        title_left = (ImageView) findViewById(R.id.title_left);
        agreement.setOnClickListener(this);
        title_left.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.agreement:
                startActivity(new Intent(this, UseragreementActivity.class));
                break;
            case R.id.title_left:
                finish();
                break;
        }

    }
}
