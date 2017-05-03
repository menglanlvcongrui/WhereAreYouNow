package com.example.administrator.whereareyounow.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.whereareyounow.R;
import com.example.administrator.whereareyounow.activity.AccountSettingActivity;
import com.example.administrator.whereareyounow.activity.PushnotificationActivity;
import com.example.administrator.whereareyounow.activity.RealnameActivity;
import com.example.administrator.whereareyounow.activity.UseragreementActivity;


public class MyFragment extends Fragment implements View.OnClickListener {
    ImageView head_change;
    TextView photo, picture, cancel;
    Dialog headDialog;
    private RelativeLayout layout_push,layout_user,layout_count,layout_realname;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        head_change = (ImageView) view.findViewById(R.id.head_change);
        layout_push = (RelativeLayout) view.findViewById(R.id.layout_push);
        layout_count = (RelativeLayout) view.findViewById(R.id.layout_count);
        layout_user= (RelativeLayout) view.findViewById(R.id.layout_user);
        layout_realname=(RelativeLayout)view.findViewById(R.id.layout_realname);
        layout_realname.setOnClickListener(this);
        layout_user.setOnClickListener(this);
        layout_count.setOnClickListener(this);
        layout_push.setOnClickListener(this);
        head_change.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.head_change:
                showHeaddialog();
                break;
            case R.id.layout_push:
                intent = new Intent(getActivity(), PushnotificationActivity.class);
                startActivity(intent);
                break;
            case R.id.layout_count:
                intent = new Intent(getActivity(), AccountSettingActivity.class);
                startActivity(intent);
                break;
            case R.id.layout_user:
                intent = new Intent(getActivity(), UseragreementActivity.class);
                startActivity(intent);
                break;
            case R.id.layout_realname:
                intent = new Intent(getActivity(), RealnameActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void showHeaddialog() {
        headDialog = new Dialog(getActivity(), R.style.ActionSheetDialogStyle);
        //填充对话框的布局
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_head, null);
        //初始化控件
        initDialogView(inflate);
        //将布局设置给Dialog
        headDialog.setContentView(inflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = headDialog.getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity(Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 40;//设置Dialog距离底部的距离
        lp.width = getResources().getDisplayMetrics().widthPixels - 40;
//       将属性设置给窗体
        dialogWindow.setAttributes(lp);
        headDialog.show();//显示对话框
    }

    private void initDialogView(View inflate) {
        photo = (TextView) inflate.findViewById(R.id.photo);
        picture = (TextView) inflate.findViewById(R.id.picture);
        cancel = (TextView) inflate.findViewById(R.id.cancel);
        picture.setOnClickListener(this);
        photo.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }
}
