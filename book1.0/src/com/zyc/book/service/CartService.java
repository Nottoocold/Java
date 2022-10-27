package com.zyc.book.service;

import com.zyc.book.pojo.User;

public interface CartService {

    //添加购物车项
    boolean addCart(Integer bookId, User user);

    //获取指定用户的购物车数量
    int getCountOfUser(User user);
}
