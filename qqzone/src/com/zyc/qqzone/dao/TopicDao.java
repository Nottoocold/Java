package com.zyc.qqzone.dao;

import com.zyc.qqzone.pojo.Topic;

import java.util.List;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/9 20:50
 */
public interface TopicDao {

    //获取指定用户的日志列表
    List<Topic> getTopicsOfUser(Integer userId);

    //添加日志
    boolean addTopic(Topic topic);

    //删除日志
    boolean deleteTopic(Topic topic);

    //获取指定日志信息
    Topic getTopicInfo(Integer id);
}
