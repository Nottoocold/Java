package com.zyc.book.dao;

import com.zyc.book.pojo.Book;

import java.util.List;

public interface BookDao {

    List<Book> getBookList();

    int getBookCount(Integer bookId);
}
