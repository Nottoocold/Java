package com.zyc.qqzone.dao.impl;

import com.zyc.qqzone.dao.ReplyDao;
import com.zyc.qqzone.pojo.Reply;
import com.zyc.ssm.basedao.BaseDao;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/9 21:03
 */
public class ReplyDaoImpl implements ReplyDao {
    @Override
    public List<Reply> getTopicOfReplies(Integer topicId) {
        return BaseDao.queryForList(Reply.class, "select * from t_reply where replyTopic = ?", topicId);
    }

    @Override
    public boolean addReply(String replyContent, Date replyDate, Integer replyAuthor, Integer replyTopic) {
        String sql = "insert into t_reply(replyContent,replyDate,replyAuthor,replyTopic) values(?,?,?,?)";
        int key = BaseDao.updateSQL(sql, replyContent, replyDate, replyAuthor, replyTopic);
        return key != -1;
    }

    @Override
    public boolean deleteReply(Integer id) {
        int i = BaseDao.updateSQL("delete from t_reply where id = ?", id);
        return i != -1;
    }

    @Override
    public Reply getReplyById(Integer id) {
        return BaseDao.queryForOne(Reply.class, "select * from t_reply where id = ?", id);
    }
}
