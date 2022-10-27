package com.zyc.qqzone.service;

import com.zyc.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/9 21:04
 */
public interface UserBasicService {

    UserBasic login(String loginId, String password);

    //获取该用户的好友信息
    List<UserBasic> getFriendList(UserBasic userBasic);

    //根据id获取指定用户信息
    UserBasic getUserBasicById(Integer id);
}
