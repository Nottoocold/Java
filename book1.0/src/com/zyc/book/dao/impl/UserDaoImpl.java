package com.zyc.book.dao.impl;

import com.zyc.book.dao.UserDao;
import com.zyc.book.pojo.User;
import com.zyc.ssm.basedao.BaseDao;

public class UserDaoImpl implements UserDao {
    @Override
    public User getUser(String name, String pwd) {
        return BaseDao.queryForOne(User.class, "select * from t_user where name = ? and pwd = ?", name, pwd);
    }
}
