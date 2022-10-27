package com.zyc.service;

import com.zyc.pojo.Book_t;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BookService {
    /**
     * 保存
     *
     * @param book
     * @return
     */
    public boolean save(Book_t book);

    /**
     * 修改
     *
     * @param book
     * @return
     */
    public boolean update(Book_t book);

    /**
     * 按id删除
     *
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 按id查询
     *
     * @param id
     * @return
     */
    public Book_t getById(Integer id);

    /**
     * 查询全部
     *
     * @return
     */
    public List<Book_t> getAll();

}
