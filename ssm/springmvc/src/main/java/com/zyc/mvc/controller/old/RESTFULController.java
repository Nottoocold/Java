package com.zyc.mvc.controller.old;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RESTFULController {

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String put(){
        System.out.println("put..");
        return "ret";
    }

    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String delete(){
        System.out.println("delete..");
        return "ret";
    }
}
