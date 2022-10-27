package com.zyc.book.service;

import com.zyc.book.pojo.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBook();

    //获取指定图书的库存
    int getBookCountByBookId(Integer bookId);
}
