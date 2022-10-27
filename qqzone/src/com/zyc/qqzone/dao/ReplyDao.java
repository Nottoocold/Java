package com.zyc.qqzone.dao;

import com.zyc.qqzone.pojo.Reply;
import com.zyc.qqzone.pojo.Topic;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/9 20:51
 */
public interface ReplyDao {

    //获取指定日志的回复列表
    List<Reply> getTopicOfReplies(Integer topicId);

    //添加回复
    boolean addReply(String replyContent, Date replyDate, Integer replyAuthor, Integer replyTopic);

    //删除回复
    boolean deleteReply(Integer replyId);

    //根据id获取指定的Reply
    Reply getReplyById(Integer id);
}
