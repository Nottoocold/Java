package org.spring.stu.service.impl;

import org.spring.stu.dao.UserDao;
import org.spring.stu.pojo.User;
import org.spring.stu.service.UserService;

import java.util.List;

/**
 * @author zyc
 * @date 2022/10/24
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
    }

    @Override
    public List<User> listUser() {
        return userDao.selectUsers();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
