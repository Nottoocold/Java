package com.zyc.spring.service.impl;

import com.zyc.spring.dao.UserDao;
import com.zyc.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userservice")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void add() {
        userDao.addUser();
    }
}
