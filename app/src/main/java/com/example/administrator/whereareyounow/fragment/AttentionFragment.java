package com.example.administrator.whereareyounow.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.whereareyounow.R;


public class AttentionFragment extends Fragment {
    private ImageView title_left;
    private ImageView title_right1;
    private TextView title_center;

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
        title_left.setVisibility(view.GONE);
        title_center.setText("我的关注");
    }
}
