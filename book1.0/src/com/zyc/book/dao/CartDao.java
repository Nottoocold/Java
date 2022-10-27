package com.zyc.book.dao;

public interface CartDao {

    //根据用户id和图书id查询购物车图书记录，若查询到则返回图书记录数,没有则返回0
    int getCartOfUserByBookIdAndUserId(Integer bookId, Integer userId);

    //根据bookId查询buyCount总记录数
    int getTotalBuyCountByBookId(Integer bookId);

    boolean updateOneRecord(Integer booId, Integer buyCount, Integer userBean);

    boolean addOneRecord(Integer bookId, Integer buyCount, Integer useId);

    int getCartItemNum(Integer userId);
}
