package com.zyc.book.service.impl;

import com.zyc.book.dao.CartDao;
import com.zyc.book.pojo.User;
import com.zyc.book.service.CartService;

public class CartServiceImpl implements CartService {
    private CartDao cartDao;
    /*
        1.若购物车中有此用户的图书记录 -> 则书的数量+1
        2.否则为此用户添加新项 图书的数量为1
     */
    @Override
    public boolean addCart(Integer bookId, User user) {
        int buyCount = cartDao.getCartOfUserByBookIdAndUserId(bookId, user.getId());
        if (buyCount > 0) {
            return cartDao.updateOneRecord(bookId, buyCount + 1, user.getId());
        }else {
            return cartDao.addOneRecord(bookId, 1, user.getId());
        }
    }

    @Override
    public int getCountOfUser(User user) {
        return cartDao.getCartItemNum(user.getId());
    }
}
