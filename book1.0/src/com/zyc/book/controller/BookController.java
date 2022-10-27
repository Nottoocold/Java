package com.zyc.book.controller;

import com.zyc.book.pojo.Book;
import com.zyc.book.service.BookService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class BookController {
    private BookService bookService;

    public String index(HttpSession session){
        List<Book> allBook = bookService.getAllBook();
        session.setAttribute("bookList", allBook);
        return "index";
    }
}
