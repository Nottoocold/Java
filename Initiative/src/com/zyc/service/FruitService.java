package com.zyc.service;

import com.zyc.pojo.PageBean;
import com.zyc.service.iml.FruitServiceImpl;

import java.util.List;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/6 上午11:58
 * @see FruitServiceImpl
 */
public interface FruitService<T> {

    List<T> select();

    T selectOne(Integer id);

    int insert(T t);

    int insert(List<T> t);

    T update(T t);

    int deleteByIds(Integer[] id);

    PageBean<T> selectByPage(Integer curPage, Integer numPerPage);
}
