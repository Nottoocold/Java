package com.zyc.mvc.controller.old;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ParamController {

    @RequestMapping("/param/servletapi/api")
    public String getParam1(HttpServletRequest request) {
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        System.out.println(username);
        System.out.println(pwd);
        return "hello";
    }

    @RequestMapping("/param")
    public String getParam2(@RequestParam("name") String username,@RequestParam("pwd") String password) {
        System.out.println(username);
        System.out.println(password);
        return "hello";
    }
}
