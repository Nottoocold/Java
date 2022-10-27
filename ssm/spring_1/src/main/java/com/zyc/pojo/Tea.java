package com.zyc.pojo;

public class Tea {
    private String tname;

    public Tea() {
    }

    @Override
    public String toString() {
        return "Tea{" +
                "tname='" + tname + '\'' +
                '}';
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
