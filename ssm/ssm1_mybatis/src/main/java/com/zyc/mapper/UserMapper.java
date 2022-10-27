package com.zyc.mapper;

import com.zyc.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    int insertUser(User user);

    int updateUser(User user);

    int deleteById(@Param("userId") Integer id);

    int deleteByIds(@Param("ids") String ids);

    User getUser(User user);

    @MapKey("uid")
    Map<String, Object> getUserToMap(@Param("uid") Integer id);

    List<User> getUserByCondition(User user);

    List<User> getUserByLike(@Param("username") String name);

    int getCountUser();
}
