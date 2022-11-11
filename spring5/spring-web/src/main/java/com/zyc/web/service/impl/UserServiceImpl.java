package com.zyc.web.service.impl;

import com.zyc.web.dao.UserDao;
import com.zyc.web.pojo.User;
import com.zyc.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zyc
 * @date 2022/10/24
 */
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
    }

    @Override
    public List<User> listUser() {
        return userDao.selectUsers();
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
