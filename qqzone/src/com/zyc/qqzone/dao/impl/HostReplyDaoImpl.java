package com.zyc.qqzone.dao.impl;

import com.zyc.qqzone.dao.HostReplyDao;
import com.zyc.qqzone.pojo.HostReply;
import com.zyc.ssm.basedao.BaseDao;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/9 21:03
 */
public class HostReplyDaoImpl implements HostReplyDao {
    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        return BaseDao.queryForOne(HostReply.class, "select * from t_host_reply where replyId = ?", replyId);
    }

    @Override
    public boolean delHostReply(Integer id) {
        int i = BaseDao.updateSQL("delete from t_host_reply where id = ?", id);
        return i != -1;
    }
}
