package com.zyc.controller;

import com.zyc.controller.code.StatusCode;
import com.zyc.controller.result.ResultData;
import com.zyc.pojo.Book_t;
import com.zyc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResultData save(@RequestBody Book_t book) {
        boolean flag = bookService.save(book);
        return new ResultData(flag, flag ? StatusCode.ADD_OK : StatusCode.ADD_ERR);
    }

    @PutMapping
    public ResultData update(@RequestBody Book_t book) {
        boolean flag = bookService.update(book);
        return new ResultData(flag, flag ? StatusCode.UPDATE_OK : StatusCode.UPDATE_ERR);
    }

    @DeleteMapping("/{id}")
    public ResultData delete(@PathVariable Integer id) {
        boolean flag = bookService.delete(id);
        return new ResultData(flag, flag ? StatusCode.DELETE_OK : StatusCode.DELETE_ERR);
    }

    @GetMapping("/{id}")
    public ResultData getById(@PathVariable Integer id) {
        Book_t book_t = bookService.getById(id);
        if (book_t != null) {
            return new ResultData(book_t, StatusCode.SELECT_OK, "selected one data");
        }
        return new ResultData(null, StatusCode.SELECT_ERR, "no data");
    }

    @GetMapping
    public ResultData getAll() {
        List<Book_t> book_tList = bookService.getAll();
        if (book_tList != null) {
            return new ResultData(book_tList, StatusCode.SELECT_OK, "selected " + book_tList.size() + " data");
        }
        return new ResultData(null, StatusCode.SELECT_ERR, "no data");
    }

}
