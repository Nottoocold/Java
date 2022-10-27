package com.zyc.book.dao.impl;

import com.zyc.book.dao.CartDao;
import com.zyc.ssm.basedao.BaseDao;

import java.util.List;

public class CartDaoImpl implements CartDao {

    @Override
    public int getCartOfUserByBookIdAndUserId(Integer bookId, Integer userId) {
        List<Object> list = BaseDao.queryColumnList("SELECT buyCount FROM t_cart_item WHERE book = ? AND userBean = ?", bookId, userId);
        if (list.size() == 0) return 0;
        return Integer.parseInt(String.valueOf(list.get(0)));
    }

    @Override
    public int getTotalBuyCountByBookId(Integer bookId) {
        List<Object> list = BaseDao.queryColumnList("SELECT SUM(buyCount) FROM t_cart_item WHERE book = ?", bookId);
        if (list.size() == 0) return 0;
        return Integer.parseInt(String.valueOf(list.get(0)));
    }

    @Override
    public boolean updateOneRecord(Integer bookId, Integer buyCount, Integer userId) {
        int i = BaseDao.updateSQL("UPDATE t_cart_item SET buyCount = ? WHERE book = ? AND userBean = ?",buyCount, bookId, userId);
        return i != -1;
    }

    @Override
    public boolean addOneRecord(Integer bookId, Integer buyCount, Integer useId) {
        int i = BaseDao.updateSQL("INSERT INTO t_cart_item(book,buyCount,userBean) VALUES(?,?,?)", bookId, buyCount, useId);
        return i != -1;
    }

    @Override
    public int getCartItemNum(Integer userId) {
        List<Object> list = BaseDao.queryColumnList("SELECT COUNT(userBean) FROM t_cart_item WHERE userBean = ?", userId);
        if (list.size() == 0) return 0;
        return Integer.parseInt(String.valueOf(list.get(0)));
    }
}
