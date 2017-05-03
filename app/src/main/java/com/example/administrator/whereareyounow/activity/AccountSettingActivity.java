package com.example.administrator.whereareyounow.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.example.administrator.whereareyounow.Dialog.ContactusDialog;
import com.example.administrator.whereareyounow.Dialog.ExitDialog;
import com.example.administrator.whereareyounow.R;

public class AccountSettingActivity extends AppCompatActivity implements View.OnClickListener{
    ExitDialog exitDialog;
    ContactusDialog contactusDialog;
    private RelativeLayout exit_account,modify_password,contact_us;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_account_setting);
        init();

    }

    private void init() {
        exit_account = (RelativeLayout) findViewById(R.id.exit_account);
        modify_password = (RelativeLayout) findViewById(R.id.modify_password);
        contact_us=(RelativeLayout)findViewById(R.id.contact_us);
        contact_us.setOnClickListener(this);
        modify_password.setOnClickListener(this);
        exit_account.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.exit_account:
                startExitDialog();
                break;
            case R.id.modify_password:
                intent=new Intent(AccountSettingActivity.this,ChangepwdActivity.class);
                startActivity(intent);
                break;
            case R.id.contact_us:
                startContactDialog();
                break;
        }
    }

    private void startContactDialog() {
        contactusDialog = new ContactusDialog(this);

        contactusDialog.setYesOnclickListener("确定", new ContactusDialog.onYesOnclickListener() {
            @Override
            public void onYesClick() {
                contactusDialog.dismiss();
                Intent intentexit = new Intent();
//                intentexit.setClass(this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);  ;
//                startActivity(intentexit);
                //  getActivity().finish();//销毁PersonalcenterFragment页面
            }
        });

        contactusDialog.setNoOnclickListener("取消", new ContactusDialog.onNoOnclickListener() {
            @Override
            public void onNoClick() {
                contactusDialog.dismiss();
            }
        });
        contactusDialog.show();
    }

    //退出账户弹出的dialog
    public void startExitDialog() {
        exitDialog = new ExitDialog(this);

        exitDialog.setYesOnclickListener("确定", new ExitDialog.onYesOnclickListener() {
            @Override
            public void onYesClick() {
                exitDialog.dismiss();
                Intent intentexit = new Intent();
//                intentexit.setClass(this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);  ;
//                startActivity(intentexit);
                //  getActivity().finish();//销毁PersonalcenterFragment页面
            }
        });

        exitDialog.setNoOnclickListener("取消", new ExitDialog.onNoOnclickListener() {
            @Override
            public void onNoClick() {
                exitDialog.dismiss();
            }
        });
        exitDialog.show();
    }
}
