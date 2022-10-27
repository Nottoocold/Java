package com.zyc.service.impl;

import com.zyc.mapper.BookMapper;
import com.zyc.pojo.Book_t;
import com.zyc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    public boolean save(Book_t book) {
        return bookMapper.save(book) > 0;
    }

    public boolean update(Book_t book) {
        return bookMapper.update(book) > 0;
    }

    public boolean delete(Integer id) {
        return bookMapper.delete(id) > 0;
    }

    public Book_t getById(Integer id) {
        return bookMapper.getById(id);
    }

    public List<Book_t> getAll() {
        return bookMapper.getAll();
    }

}
