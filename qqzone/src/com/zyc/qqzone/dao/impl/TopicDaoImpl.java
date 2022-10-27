package com.zyc.qqzone.dao.impl;

import com.zyc.qqzone.dao.TopicDao;
import com.zyc.qqzone.pojo.Topic;
import com.zyc.ssm.basedao.BaseDao;

import java.util.List;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/9 21:03
 */
public class TopicDaoImpl implements TopicDao {
    @Override
    public List<Topic> getTopicsOfUser(Integer userId) {
        return BaseDao.queryForList(Topic.class, "select * from t_topic where author = ?", userId);
    }

    @Override
    public boolean addTopic(Topic topic) {
        return false;
    }

    @Override
    public boolean deleteTopic(Topic topic) {
        return false;
    }

    @Override
    public Topic getTopicInfo(Integer id) {
        return BaseDao.queryForOne(Topic.class, "select * from t_topic where id = ?", id);
    }
}
