package com.zyc.java.net.qq.common;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zyc
 * @date 2022/10/15
 */
public class Msg implements Serializable {
    private String msg;
    private Integer code;
    private String from;
    private String to;
    private LocalDateTime time;

    public Msg() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
