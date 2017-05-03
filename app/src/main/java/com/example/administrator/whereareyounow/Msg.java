package com.example.administrator.whereareyounow;

/**
 * Created by GX on 2017/5/3 0003.
 */

public class Msg {

    public static final int TYPE_RECEIVE = 0;
    public static final int TYPE_SEND = 1;
    private String content;
    private int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
