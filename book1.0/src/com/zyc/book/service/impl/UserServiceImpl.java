package com.zyc.book.service.impl;

import com.zyc.book.dao.UserDao;
import com.zyc.book.pojo.User;
import com.zyc.book.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Override
    public User login(String name, String pwd) {
        return userDao.getUser(name, pwd);
    }
}
