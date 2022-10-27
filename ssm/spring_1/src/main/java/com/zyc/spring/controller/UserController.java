package com.zyc.spring.controller;

import com.zyc.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

//默认组件id 类名首字母小写
@Controller
public class UserController {
    /*
        @Autowire 注解
	    Declares whether the annotated dependency is required.
	    Defaults to true
        boolean required() default true;
     */
    @Autowired //(required = false)
    @Qualifier("userservice")
    private UserService userService;

//    public void setUserService(UserService userService){
//        this.userService = userService;
//    }

    public void add() {
        userService.add();
    }
}
