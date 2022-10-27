package com.zyc.spring.dao.impl;

import com.zyc.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("ok...");
    }
}
