package com.zyc.qqzone.service;

import com.zyc.qqzone.pojo.Topic;
import com.zyc.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/9 21:05
 */
public interface TopicService {

    //查询特定用户的日志列表
    List<Topic> getTopicList(UserBasic userBasic);

    //根据id获取特定topic
    Topic getTopicById(Integer topicId);

    //根据id获取指定的topic信息，包含这个topic关联的作者信息
    Topic getTopic(Integer id);

    //删除特定的topic
    boolean deleteTopic(Integer id);
}
