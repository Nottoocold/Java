package com.zyc.qqzone.service;

import com.zyc.qqzone.pojo.HostReply;
import com.zyc.qqzone.pojo.Reply;
import com.zyc.qqzone.pojo.Topic;

import java.util.List;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/9 21:06
 */
public interface ReplyService {

    //根据topic的id获取关联的所有的回复
    List<Reply> getReplyListByTopicId(Integer topicId);

    //添加回复
    boolean addReply(Reply reply);

    //删除指定的回复
    boolean deleteReply(Integer id);

    //删除指定的日志关联的所有的回复
    boolean delReplyList(Topic topic);
}
