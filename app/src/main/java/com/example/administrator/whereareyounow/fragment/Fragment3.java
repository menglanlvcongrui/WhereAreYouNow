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

/**
 * Created by zq on 2016/11/12.
 */


public class Fragment3 extends Fragment {
    private View view;
    private RelativeLayout mRelativeLayout;
    private TextView mTextView;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        view=getView();
        initView();
    }
    private void initView() {
        mRelativeLayout= (RelativeLayout) view.findViewById(R.id.fragment_background);
        mRelativeLayout.setBackgroundResource(R.drawable.guide3);
        mTextView = (TextView) view.findViewById(R.id.fragment_text);
        mTextView.setVisibility(View.VISIBLE);
        sp = getActivity().getSharedPreferences("Whereareyou", Context.MODE_PRIVATE);
        editor= sp.edit();
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("index", 1);
                editor.commit();
                getActivity().startActivity(new Intent( getActivity(), MainActivity.class));
                getActivity().finish();
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
