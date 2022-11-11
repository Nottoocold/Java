package com.zyc.web.dao;

import com.zyc.web.pojo.User;

import java.util.List;

/**
 * @author zyc
 * @date 2022/10/24
 */
public interface UserDao {

    List<User> selectUsers();
}
