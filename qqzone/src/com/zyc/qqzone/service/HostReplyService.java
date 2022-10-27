package com.zyc.qqzone.service;

import com.zyc.qqzone.pojo.HostReply;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/9 21:08
 */
public interface HostReplyService {

    HostReply getHostReplyByReplyId(Integer replyId);

    boolean deleteHostReply(Integer id);
}
