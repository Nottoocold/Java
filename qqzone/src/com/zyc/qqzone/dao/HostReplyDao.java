package com.zyc.qqzone.dao;

import com.zyc.qqzone.pojo.HostReply;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/9 20:51
 */
public interface HostReplyDao {

    //根据replyId查询关联的HostReply实体
    HostReply getHostReplyByReplyId(Integer replyId);

    //删除特定的HostReply
    boolean delHostReply(Integer id);
}
