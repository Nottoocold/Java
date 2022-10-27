package com.zyc.dao;

import com.zyc.dao.iml.FruitDaoImpl;

import java.util.List;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/6 上午11:48
 * @see FruitDaoImpl
 */
public interface FruitDao<T> {

    List<T> getBeanList();

    T getBeanObject(Integer id);

    int updateById(T t);

    int insert(T t);

    int deleteById(Integer id);

    List<T> selectByPage(Integer curPage, Integer numPerPage);

    int selectTotalCount();
}
