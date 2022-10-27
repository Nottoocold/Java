package com.zyc.controller.result;

import com.zyc.controller.code.StatusCode;

public class ResultData {
    private Object data;
    private StatusCode code;
    private String msg;

    public ResultData(Object data, StatusCode code) {
        this.data = data;
        this.code = code;
    }

    public ResultData(Object data, StatusCode code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public ResultData setData(Object data) {
        this.data = data;
        return this;
    }

    public StatusCode getCode() {
        return code;
    }

    public ResultData setCode(StatusCode code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultData setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
