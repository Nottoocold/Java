package com.zyc.qqzone.controller;

import com.zyc.qqzone.pojo.Reply;
import com.zyc.qqzone.pojo.Topic;
import com.zyc.qqzone.pojo.UserBasic;
import com.zyc.qqzone.service.ReplyService;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/9 23:07
 */
public class ReplyController {
    private ReplyService replyService;

    public String addReply(String content, Integer topicId, HttpSession session) {
        Reply reply = new Reply();
        reply.setReplyContent(content);
        reply.setReplyDate(new Date());
        reply.setReplyTopic(topicId);
        UserBasic user = (UserBasic) session.getAttribute("userBasic");
        reply.setReplyAuthor(user.getId());
        boolean flag = replyService.addReply(reply);
        return flag ? "redirect:topic.do?opt=topicDetail&id="+topicId : "";
    }

    public String delReply(Integer replyId, Integer topicId) {
        replyService.deleteReply(replyId);
        return "redirect:topic.do?opt=topicDetail&id=" + topicId;
    }
}
