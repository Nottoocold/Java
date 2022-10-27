package com.zyc.qqzone.pojo;

import java.util.Date;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/9 20:25
 */
public class Reply {
    private Integer id;
    private String replyContent;
    private Date replyDate;
    private Integer replyAuthor;
    private Integer replyTopic;

    private UserBasic replyAuthorName; //本次回复的作者 M:1
    private Topic replyTopicTitle; // 回复的日志 M:1
    private HostReply hostReply; // 日志作者的回复 1:1

    public Reply() {
    }

    public Integer getReplyAuthor() {
        return replyAuthor;
    }

    public void setReplyAuthor(Integer replyAuthor) {
        this.replyAuthor = replyAuthor;
    }

    public void setReplyTopic(Integer replyTopic) {
        this.replyTopic = replyTopic;
    }

    public UserBasic getReplyAuthorName() {
        return replyAuthorName;
    }

    public void setReplyAuthorName(UserBasic replyAuthorName) {
        this.replyAuthorName = replyAuthorName;
    }

    public Topic getReplyTopicTitle() {
        return replyTopicTitle;
    }

    public void setReplyTopicTitle(Topic replyTopicTitle) {
        this.replyTopicTitle = replyTopicTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    public Integer getReplyTopic() {
        return replyTopic;
    }

    public HostReply getHostReply() {
        return hostReply;
    }

    public void setHostReply(HostReply hostReply) {
        this.hostReply = hostReply;
    }
}
