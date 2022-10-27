package com.zyc.book.dao.impl;

import com.zyc.book.dao.BookDao;
import com.zyc.book.pojo.Book;
import com.zyc.ssm.basedao.BaseDao;

import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> getBookList() {
        //图书状态ok且库存大于0的图书列表
        return BaseDao.queryForList(Book.class, "select * from t_book where bookStatus = 0 and bookCount > 0");
    }

    @Override
    public int getBookCount(Integer bookId) {
        List<Object> list = BaseDao.queryColumnList("select bookCount from t_book where id = ? and bookStatus = 0", bookId);
        return Integer.parseInt(String.valueOf(list.get(0)));
    }
}
