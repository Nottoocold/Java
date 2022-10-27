package com.zyc.proxy;

public class ImplClass implements NeedIm {
    @Override
    public String getMsg(String msg) {
        return "消息:" + msg;
    }

    @Override
    public Integer getInt(Integer i) {
        return i;
    }
}
