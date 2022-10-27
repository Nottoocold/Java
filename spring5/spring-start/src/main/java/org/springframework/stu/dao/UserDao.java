package org.springframework.stu.dao;

import org.springframework.stu.pojo.User;

import java.util.List;

/**
 * @author zyc
 * @date 2022/10/24
 */
public interface UserDao {

    List<User> selectUsers();
}
