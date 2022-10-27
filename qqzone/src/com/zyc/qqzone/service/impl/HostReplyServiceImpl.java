package com.zyc.qqzone.service.impl;

import com.zyc.qqzone.dao.HostReplyDao;
import com.zyc.qqzone.pojo.HostReply;
import com.zyc.qqzone.service.HostReplyService;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/9 21:51
 */
public class HostReplyServiceImpl implements HostReplyService {
    private HostReplyDao hostReplyDao;

    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        return hostReplyDao.getHostReplyByReplyId(replyId);
    }

    @Override
    public boolean deleteHostReply(Integer id) {
        return hostReplyDao.delHostReply(id);
    }
}
