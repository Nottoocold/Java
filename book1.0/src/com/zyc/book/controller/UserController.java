package com.zyc.book.controller;

import com.zyc.book.pojo.User;
import com.zyc.book.service.CartService;
import com.zyc.book.service.UserService;

import javax.servlet.http.HttpSession;

public class UserController {

    private UserService userService;
    private CartService cartService;

    public String login(String name, String pwd, HttpSession session){
        User user = userService.login(name, pwd);
        if (user != null){
            int cartNum = cartService.getCountOfUser(user);
            session.setAttribute("user", user);
            session.setAttribute("cartNum", cartNum);
            return "redirect:book.do";
        }
        return "user/login";
    }
}
