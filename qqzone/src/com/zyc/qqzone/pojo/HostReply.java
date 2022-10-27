package com.zyc.qqzone.pojo;

import java.util.Date;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/9 20:27
 */
public class HostReply {
    private Integer id;
    private String hostReplyContent;
    private Date hostReplyDate;
    private Integer hostId;
    private Integer replyId;

    private UserBasic hostInfo; // 作者 M:1
    private Reply reply; // 回复会话 1:1

    public HostReply() {
    }

    public Integer getHostId() {
        return hostId;
    }

    public void setHostId(Integer hostId) {
        this.hostId = hostId;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHostReplyContent() {
        return hostReplyContent;
    }

    public void setHostReplyContent(String hostReplyContent) {
        this.hostReplyContent = hostReplyContent;
    }

    public Date getHostReplyDate() {
        return hostReplyDate;
    }

    public void setHostReplyDate(Date hostReplyDate) {
        this.hostReplyDate = hostReplyDate;
    }

    public UserBasic getHostInfo() {
        return hostInfo;
    }

    public void setHostInfo(UserBasic hostInfo) {
        this.hostInfo = hostInfo;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }
}
