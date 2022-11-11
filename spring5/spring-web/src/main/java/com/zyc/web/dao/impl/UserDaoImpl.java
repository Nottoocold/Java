package com.zyc.web.dao.impl;

import com.zyc.web.dao.UserDao;
import com.zyc.web.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

/**
 * @author zyc
 * @date 2022/10/24
 */
@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

    public UserDaoImpl(){
        log.info("无参构造");
    }

    @Override
    public List<User> selectUsers() {
        return Collections.singletonList(new User("赵永超", 23));
    }

}
