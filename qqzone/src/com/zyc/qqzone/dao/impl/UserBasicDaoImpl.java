package com.zyc.qqzone.dao.impl;

import com.zyc.qqzone.dao.UserBasicDao;
import com.zyc.qqzone.pojo.UserBasic;
import com.zyc.ssm.basedao.BaseDao;

import java.util.List;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/9 21:01
 */
public class UserBasicDaoImpl implements UserBasicDao {

    @Override
    public UserBasic getUserBasic(String loginId, String password) {
        return BaseDao.queryForOne(UserBasic.class, "select * from t_user_basic where loginID = ? and pwd = ?", loginId, password);
    }

    @Override
    public List<Object> getFriendIdList(Integer userId) {
        return BaseDao.queryColumnList("select fid as id from t_friend_relations where uid = ?", userId);
    }

    @Override
    public UserBasic getUserInfo(Integer id) {
        return BaseDao.queryForOne(UserBasic.class, "select * from t_user_basic where id = ?", id);
    }
}
