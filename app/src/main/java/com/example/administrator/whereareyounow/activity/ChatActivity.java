package com.example.administrator.whereareyounow.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.whereareyounow.Msg;
import com.example.administrator.whereareyounow.R;
import com.example.administrator.whereareyounow.adapter.MsgAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {
    List<Msg> msgList = new ArrayList<>();
    EditText inputText;
    Button btnSend;
    RecyclerView recyclerView;
    private MsgAdapter adapter;
    LinearLayout line;
    private TextView tv_title_center;
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
        setContentView(R.layout.activity_chat);
//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        initMsg();
        init();
        adapter = new MsgAdapter(msgList);
        recyclerView.setAdapter(adapter);

        tv_title_center.setText("聊天室");
    }

    private void init() {
        btnSend = (Button) findViewById(R.id.btnSend);
        inputText = (EditText) findViewById(R.id.input_text);
        recyclerView = (RecyclerView) findViewById(R.id.msg_recyclerView);
        line = (LinearLayout) findViewById(R.id.line);
        tv_title_center = (TextView) findViewById(R.id.title_center);
        title_left = (ImageView) findViewById(R.id.title_left);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        title_left.setOnClickListener(this);
        btnSend.setOnClickListener(this);
    }
    boolean state=true;
    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnSend:
                String content = inputText.getText().toString().trim();
                if (!content.equals("")&&state) {
                    msgList.add(new Msg(content, Msg.TYPE_SEND));
                    adapter.notifyItemInserted(msgList.size() - 1);
                    recyclerView.scrollToPosition(msgList.size() - 1);
                    inputText.setText("");
                    state=false;
                }else if (!content.equals("")&&!state){

                    msgList.add(new Msg(content, Msg.TYPE_RECEIVE));
                    adapter.notifyItemInserted(msgList.size() - 1);
                    recyclerView.scrollToPosition(msgList.size() - 1);
                    inputText.setText("");
                    state=true;
                }
                break;
            case R.id.title_left:
                finish();
                break;
        }

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

