package com.zyc.mapper;

import com.zyc.pojo.Teacher;
import com.zyc.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResultMapMapper {

    List<Teacher> getTeacherByName(@Param("name") String name);

    List<User> getUser();
}
