package com.zyc.web.controller;

import com.zyc.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

/**
 * @author zyc
 * @date 2022/11/3
 */
@Controller
public class IndexController {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);
    private UserService userService;

    @RequestMapping(value = "/users")
    public ModelAndView index() {
        log.info("handler running..");
        ModelAndView mav = new ModelAndView();
        mav.addObject("date", LocalDateTime.now());
        mav.addObject("users", userService.listUser());
        mav.setViewName("index");
        return mav;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
