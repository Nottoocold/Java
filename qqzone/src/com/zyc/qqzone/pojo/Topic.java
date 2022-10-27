package com.zyc.qqzone.pojo;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/9 20:23
 */
public class Topic {
    private Integer id;
    private String title;
    private String content;
    private Date topicDate;
    private Integer author; // 一篇日志的作者id 1:M

    private UserBasic authorInfo;
    private List<Reply> replies; // 一篇日志的所有回复集合 1:N

    public Topic() {
    }

    public Topic(Integer id, String title, String content, Date topicDate, Integer author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.topicDate = topicDate;
        this.author = author;
    }

    public Topic(Integer id) {
        this.id = id;
    }

    public UserBasic getAuthorInfo() {
        return authorInfo;
    }

    public void setAuthorInfo(UserBasic authorInfo) {
        this.authorInfo = authorInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTopicDate() {
        return topicDate;
    }

    public void setTopicDate(Date topicDate) {
        this.topicDate = topicDate;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }
}
