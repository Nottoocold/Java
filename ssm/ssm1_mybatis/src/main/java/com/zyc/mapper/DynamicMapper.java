package com.zyc.mapper;

import com.zyc.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicMapper {
    /**
     * 通过数组批量删除
     */
    int deleteMoreByArr(@Param("ids") Integer[] arr);

    int deleteMoreByOr(@Param("ids") Integer[] arr);

    /**
     * 批量添加,通过list集合
     */
    int insertMoreByList(@Param("users") List<User> users);

    List<User> selectA();
}
