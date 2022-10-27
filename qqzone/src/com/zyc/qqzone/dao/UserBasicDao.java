package com.zyc.qqzone.dao;

import com.zyc.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/9 20:50
 */
public interface UserBasicDao {

    //根据账号和密码查询用户
    UserBasic getUserBasic(String loginId, String password);

    //获取指定用户的好友的id列表
    List<Object> getFriendIdList(Integer userId);

    //根据id查询用户信息
    UserBasic getUserInfo(Integer id);
}
