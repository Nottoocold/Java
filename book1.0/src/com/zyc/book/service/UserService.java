package com.zyc.book.service;

import com.zyc.book.pojo.User;

public interface UserService {
    //登录
    User login(String name, String pwd);
}
