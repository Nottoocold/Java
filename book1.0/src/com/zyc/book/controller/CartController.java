package com.zyc.book.controller;

import com.zyc.book.pojo.User;
import com.zyc.book.service.CartService;

import javax.servlet.http.HttpSession;

//购物车控制器
public class CartController {
    private CartService cartService;

    public String addCart(Integer bookId, HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user == null)//用户未登录,不允许将图书加入购物车,返回登录页面
            return "redirect:user/login";
        boolean flag = cartService.addCart(bookId, user);
        if (flag){
            //获取该用户购物车中的数量
            int cartNum = cartService.getCountOfUser(user);
            session.setAttribute("cartNum", cartNum);
        }
        return flag ? "redirect:book.do" : "user/login";
    }
}
