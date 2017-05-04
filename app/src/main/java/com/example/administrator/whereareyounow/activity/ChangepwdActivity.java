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

public class ChangepwdActivity extends AppCompatActivity {
TextView forgetpwd;
    private TextView tv_title_center;
    private ImageView iv;
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
        forgetpwd= (TextView) findViewById(R.id.forgetpwd);
        tv_title_center= (TextView)findViewById(R.id.title_center);
        iv= (ImageView) findViewById(R.id.title_right1);
        iv.setImageResource(R.drawable.love);
        tv_title_center.setText("修改密码");
        forgetpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ChangepwdActivity.this,ForgetpwdActivity.class);
                startActivity(intent);
            }
        });
    }
}
