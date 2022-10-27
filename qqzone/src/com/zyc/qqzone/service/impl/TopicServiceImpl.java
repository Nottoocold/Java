package com.zyc.qqzone.service.impl;

import com.zyc.qqzone.dao.TopicDao;
import com.zyc.qqzone.pojo.Reply;
import com.zyc.qqzone.pojo.Topic;
import com.zyc.qqzone.pojo.UserBasic;
import com.zyc.qqzone.service.ReplyService;
import com.zyc.qqzone.service.TopicService;
import com.zyc.qqzone.service.UserBasicService;

import java.util.List;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/9 21:22
 */
public class TopicServiceImpl implements TopicService {
    private TopicDao topicDao;
    private UserBasicService userBasicService;
    private ReplyService replyService;

    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return topicDao.getTopicsOfUser(userBasic.getId());
    }

    @Override
    public Topic getTopicById(Integer topicId) {
        //获取日志的信息
        Topic topic = topicDao.getTopicInfo(topicId);
        //获取日志的作者信息
        UserBasic author = userBasicService.getUserBasicById(topic.getAuthor());
        topic.setAuthorInfo(author);
        //获取日志的所有回复信息
        List<Reply> replies = replyService.getReplyListByTopicId(topic.getId());
        replies.forEach(r->{r.setReplyTopicTitle(topic);});
        topic.setReplies(replies);
        return topic;
    }

    @Override
    public Topic getTopic(Integer id) {
        Topic topic = topicDao.getTopicInfo(id);
        Integer author = topic.getAuthor();
        UserBasic user = userBasicService.getUserBasicById(author);
        topic.setAuthorInfo(user);
        return topic;
    }

    @Override
    public boolean deleteTopic(Integer id) {
        Topic topic = topicDao.getTopicInfo(id);
        if (topic != null) {
            replyService.delReplyList(topic);
            topicDao.deleteTopic(topic);
            return true;
        }
        return false;
    }
}
