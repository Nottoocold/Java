package com.zyc.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class My {
    private String name;
    private String[] hobbies;
    private Map<Integer, String> record;
    private List<Character> chars;

    public My() {
        System.out.println("1.创建对象...");
    }

    public void initM() {
        System.out.println("3.初始化...");
    }

    public void destM() {
        System.out.println("4.销毁...");
    }

    @Override
    public String toString() {
        return "My{" +
                "name='" + name + '\'' +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", record=" + record +
                ", chars=" + chars +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2.Name依赖注入");
        this.name = name;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        System.out.println("2.hobbies依赖注入");
        this.hobbies = hobbies;
    }

    public Map<Integer, String> getRecord() {
        return record;
    }

    public void setRecord(Map<Integer, String> record) {
        System.out.println("2.records依赖注入");
        this.record = record;
    }

    public List<Character> getChars() {
        return chars;
    }

    public void setChars(List<Character> chars) {
        System.out.println("2.chars依赖注入");
        this.chars = chars;
    }
}
