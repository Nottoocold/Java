package com.zyc.mvc.controller.old;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/test.do")
public class HelloController {

    //仅仅页面跳转的功能，可以使用视图控制器实现
/*    @RequestMapping("/")
    public String index() {
        return "index";
    }*/

    @RequestMapping(
            value = {"/he*llo", "/second"},
            method = {RequestMethod.GET, RequestMethod.POST},
            headers = "referer"
            //params = {"username","!pwd","age!=20"}
    )
    public String hello() {
        return "hello";
    }

    @RequestMapping("/para*/{name}/{pwd}")
    public String para(@PathVariable("name") String name, @PathVariable("pwd") String pwd) {
        System.out.println(name + "--" + pwd);
        return "hello";
    }
}
