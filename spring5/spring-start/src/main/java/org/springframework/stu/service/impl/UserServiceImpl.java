package org.springframework.stu.service.impl;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.stu.dao.UserDao;
import org.springframework.stu.pojo.User;
import org.springframework.stu.service.UserService;

import java.util.List;

/**
 * @author zyc
 * @date 2022/10/24
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final SqlSessionFactory sqlsessionFactory;
    private final Configuration configuration;

    public UserServiceImpl(final UserDao userDao, final SqlSessionFactory sqlSessionFactory, final Configuration configuration) {
        this.userDao = userDao;
        this.sqlsessionFactory = sqlSessionFactory;
        this.configuration = configuration;
    }

    @Override
    public List<User> listUser() {
        SqlSession sqlSession = sqlsessionFactory.openSession();
        System.out.println(sqlSession.getConnection());
        sqlSession.close();
        configuration.getVariables().stringPropertyNames().forEach(System.out::println);
        return userDao.selectUsers();
    }
}
