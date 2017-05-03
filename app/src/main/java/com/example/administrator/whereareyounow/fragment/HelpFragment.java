package com.example.administrator.whereareyounow.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.example.administrator.whereareyounow.R;


public class HelpFragment extends Fragment {

    private LinearLayout linearLayout;
    private RadioGroup radioGroup;
    private FragmentManager fm;
    private FragmentTransaction ft;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_help, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linearLayout=(LinearLayout)view.findViewById(R.id.content);
        radioGroup= (RadioGroup)view.findViewById(R.id.rg);
        fm = getFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.content, new DefaultFragment());
        ft.commit();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ft = fm.beginTransaction();
                switch(checkedId){

                    case R.id.button:
                        ft.replace(R.id.content, new DefaultFragment());
                        break;
                    case R.id.button1:
                        ft.replace(R.id.content, new TimeFragment());
                        break;
                    case R.id.button2:
                        ft.replace(R.id.content, new DistanceFragment());
                        break;
                    default:
                        break;
                }
                ft.commit();
            }
        });
    }
}
