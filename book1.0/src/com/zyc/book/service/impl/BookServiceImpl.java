package com.zyc.book.service.impl;

import com.zyc.book.dao.BookDao;
import com.zyc.book.pojo.Book;
import com.zyc.book.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao ;
    @Override
    public List<Book> getAllBook() {
        return bookDao.getBookList();
    }

    @Override
    public int getBookCountByBookId(Integer bookId) {
        return bookDao.getBookCount(bookId);
    }
}
