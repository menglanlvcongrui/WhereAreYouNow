package com.example.administrator.whereareyounow.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.whereareyounow.MainActivity;
import com.example.administrator.whereareyounow.R;
import com.example.administrator.whereareyounow.activity.LoginActivity;
import com.example.administrator.whereareyounow.activity.SigninActivity;

/**
 * Created by zq on 2016/11/12.
 */


public class Fragment3 extends Fragment implements View.OnClickListener {
    private View view;
    private RelativeLayout mRelativeLayout;
    private TextView mTextView;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    private TextView login,signin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        view = getView();
        initView();
    }

    private void initView() {
        mRelativeLayout = (RelativeLayout) view.findViewById(R.id.fragment_background);
        mRelativeLayout.setBackgroundResource(R.drawable.guide3);
        mTextView = (TextView) view.findViewById(R.id.see_intent);
        signin=(TextView)view.findViewById(R.id.signin);
        login=(TextView)view.findViewById(R.id.login);
        mTextView.setVisibility(View.VISIBLE);
        signin.setVisibility(View.VISIBLE);
        login.setVisibility(View.VISIBLE);
        sp = getActivity().getSharedPreferences("Whereareyou", Context.MODE_PRIVATE);
        editor = sp.edit();
        mTextView.setOnClickListener(this);
        signin.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.see_intent:
                getActivity().startActivity(new Intent(getActivity(), MainActivity.class));
                getActivity().finish();
                commitShared();
                break;
            case R.id.signin:
                getActivity().startActivity(new Intent(getActivity(), SigninActivity.class));
//                commitShared();
                break;
            case R.id.login:
                getActivity().startActivity(new Intent(getActivity(), LoginActivity.class));
//                commitShared();
                break;
        }
    }

    private void commitShared() {
        editor.putInt("index", 1);
        editor.commit();
    }

}
