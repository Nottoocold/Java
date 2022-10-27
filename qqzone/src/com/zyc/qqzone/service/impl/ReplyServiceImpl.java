package com.zyc.qqzone.service.impl;

import com.zyc.qqzone.dao.ReplyDao;
import com.zyc.qqzone.pojo.HostReply;
import com.zyc.qqzone.pojo.Reply;
import com.zyc.qqzone.pojo.Topic;
import com.zyc.qqzone.pojo.UserBasic;
import com.zyc.qqzone.service.HostReplyService;
import com.zyc.qqzone.service.ReplyService;
import com.zyc.qqzone.service.TopicService;
import com.zyc.qqzone.service.UserBasicService;

import java.util.List;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/9 21:35
 */
public class ReplyServiceImpl implements ReplyService {
    private ReplyDao replyDao;
    private HostReplyService hostReplyService;
    private UserBasicService userBasicService;

    @Override
    public List<Reply> getReplyListByTopicId(Integer topicId) {
        List<Reply> replies = replyDao.getTopicOfReplies(topicId);
        //遍历所有的回复 若其中包含作者回复 则设置之
        for (Reply reply : replies) {
            //回复的作者
            UserBasic replyAuthor = userBasicService.getUserBasicById(reply.getReplyAuthor());
            reply.setReplyAuthorName(replyAuthor);
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(reply.getId());
            if (hostReply != null)
                reply.setHostReply(hostReply);
        }
        return  replies;
    }

    @Override
    public boolean addReply(Reply reply) {
        return replyDao.addReply(reply.getReplyContent(), reply.getReplyDate(), reply.getReplyAuthor(), reply.getReplyTopic());
    }

    @Override
    public boolean deleteReply(Integer id) {
        Reply reply = replyDao.getReplyById(id);
        if (reply != null) {
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(reply.getId());
            if (hostReply != null) {//如果有日志作者回复则先删除日志作者回复
                if (hostReplyService.deleteHostReply(hostReply.getId()))
                    return replyDao.deleteReply(id);//子表删除成功再删除父表
            }else
                return replyDao.deleteReply(id);//此回复没有关联的主人回复
        }
        return false;
    }

    @Override
    public boolean delReplyList(Topic topic) {

        return false;
    }
}
