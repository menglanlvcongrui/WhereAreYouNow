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

public class ChangepwdActivity extends AppCompatActivity implements View.OnClickListener {
    TextView forgetpwd;
    private TextView tv_title_center;
    private ImageView iv;
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
        setContentView(R.layout.activity_changepsd);
        init();
    }

    private void init() {
        forgetpwd = (TextView) findViewById(R.id.forgetpwd);
        tv_title_center = (TextView) findViewById(R.id.title_center);
        iv = (ImageView) findViewById(R.id.title_right1);
        title_left = (ImageView) findViewById(R.id.title_left);
        title_left.setOnClickListener(this);
        iv.setVisibility(View.VISIBLE);
        iv.setImageResource(R.drawable.change_password);
        tv_title_center.setText("修改密码");
        forgetpwd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.forgetpwd:
                intent = new Intent(ChangepwdActivity.this, ForgetpwdActivity.class);
                startActivity(intent);
                break;
            case R.id.title_left:
                finish();
                break;
        }
    }
}
