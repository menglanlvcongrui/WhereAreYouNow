package com.example.administrator.whereareyounow.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.administrator.whereareyounow.Msg;
import com.example.administrator.whereareyounow.R;
import com.example.administrator.whereareyounow.adapter.MsgAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    List<Msg> msgList = new ArrayList<>();
    EditText inputText;
    Button btnSend;
    RecyclerView recyclerView;
    private MsgAdapter adapter;
    InputMethodManager imm;
    LinearLayout line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_chat);
//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE |
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        initMsg();
        init();
        adapter = new MsgAdapter(msgList);
        recyclerView.setAdapter(adapter);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputText.getText().toString().trim();
                if (!content.equals("")) {
                    msgList.add(new Msg(content, Msg.TYPE_SEND));
                    adapter.notifyItemInserted(msgList.size() - 1);
                    recyclerView.scrollToPosition(msgList.size() - 1);
                    inputText.setText("");
                }
            }
        });
    }

    private void init() {
        btnSend = (Button) findViewById(R.id.btnSend);
        inputText = (EditText) findViewById(R.id.input_text);
        recyclerView = (RecyclerView) findViewById(R.id.msg_recyclerView);
        line = (LinearLayout) findViewById(R.id.line);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void initMsg() {
        Msg msg1 = new Msg("hello sealong", Msg.TYPE_RECEIVE);
        msgList.add(msg1);
        Msg msg2 = new Msg("hello peipei", Msg.TYPE_SEND);
        msgList.add(msg2);
        Msg msg = new Msg("What are you doing", Msg.TYPE_RECEIVE);
        msgList.add(msg);
    }
}

