package com.zyc.book.dao;

import com.zyc.book.pojo.User;

public interface UserDao {
    //根据用户名和密码查询用户
    User getUser(String name, String pwd);
}
