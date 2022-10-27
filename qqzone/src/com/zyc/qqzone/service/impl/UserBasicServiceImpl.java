package com.zyc.qqzone.service.impl;

import com.zyc.qqzone.dao.UserBasicDao;
import com.zyc.qqzone.dao.impl.UserBasicDaoImpl;
import com.zyc.qqzone.pojo.UserBasic;
import com.zyc.qqzone.service.UserBasicService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/9 21:09
 */
public class UserBasicServiceImpl implements UserBasicService {
    private UserBasicDao userBasicDao ;

    @Override
    public UserBasic login(String loginId, String password) {
        return userBasicDao.getUserBasic(loginId, password);
    }

    @Override
    public List<UserBasic> getFriendList(UserBasic userBasic) {
        List<Object> friendsIDS = userBasicDao.getFriendIdList(userBasic.getId());
        List<UserBasic> friendList = new ArrayList<>(friendsIDS.size());
        for (Object fid : friendsIDS) {
            UserBasic f_info = userBasicDao.getUserInfo(Integer.parseInt(String.valueOf(fid)));
            friendList.add(f_info);
        }
        return friendList;
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        return userBasicDao.getUserInfo(id);
    }
}
