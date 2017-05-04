package com.example.administrator.whereareyounow.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.administrator.whereareyounow.R;
import com.example.administrator.whereareyounow.activity.InformationDetailsActivity;


public class AttentionFragment extends Fragment implements View.OnClickListener {
    private ImageView title_left;
    private ImageView title_right1;
    private TextView title_center;
    private LinearLayout line1,line2,line3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_attention, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title_left= (ImageView) view.findViewById(R.id.title_left);
        title_center= (TextView) view.findViewById(R.id.title_center);
        title_right1= (ImageView) view.findViewById(R.id.title_right1);
        line1= (LinearLayout) view.findViewById(R.id.line1);
        line2= (LinearLayout) view.findViewById(R.id.line2);
        line3= (LinearLayout) view.findViewById(R.id.line3);
        line1.setOnClickListener(this);
        line2.setOnClickListener(this);
        line3.setOnClickListener(this);
        title_left.setVisibility(view.GONE);
        title_center.setText("我的关注");

    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch(v.getId()){
            case R.id.line1:
                intent.setClass(getContext(), InformationDetailsActivity.class);
               break;
            case R.id.line2:
                intent.setClass(getContext(), InformationDetailsActivity.class);
                break;
            case R.id.line3:
                intent.setClass(getContext(), InformationDetailsActivity.class);
                break;

        }
        startActivity(intent);
    }
}
