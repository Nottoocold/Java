package com.zyc.pojo;

import java.util.Arrays;
import java.util.List;

public class User {
    private Integer uid;
    private String name;
    private Tea tea;
    private Hello[] hellos;
    private List<Hello> helloList;

    public User() {
    }

    public User(Integer uid, String name, Tea tea) {
        this.uid = uid;
        this.name = name;
        this.tea = tea;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", tea=" + tea +
                ", hellos=" + Arrays.toString(hellos) +
                ", helloList=" + helloList +
                '}';
    }

    public List<Hello> getHelloList() {
        return helloList;
    }

    public void setHelloList(List<Hello> helloList) {
        this.helloList = helloList;
    }

    public Hello[] getHellos() {
        return hellos;
    }

    public void setHellos(Hello[] hellos) {
        this.hellos = hellos;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tea getTea() {
        return tea;
    }

    public void setTea(Tea tea) {
        this.tea = tea;
    }
}
