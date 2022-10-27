package com.zyc.mvc.controller;

import com.zyc.mvc.controller.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

//@RestController
@Controller
public class TestAjaxController {

    @ResponseBody // 可直接将方法的返回值当作响应体响应给客户端
    @RequestMapping("/ajax")
    public String ajax(Integer id, @RequestBody Person body) {
        System.out.println(id);
        System.out.println(body);
        return "Ajax";
    }

    @ResponseBody
    @RequestMapping("/ajax/list")
    public List<String> list(){
        String[] s = {"zyc","da","mn"};
        List<String> asList = Arrays.asList(s);
        return new ArrayList<>(asList);
    }

    @ResponseBody
    @RequestMapping("/ajax/map")
    public Map<String,Integer> map(){
        Map<String,Integer> map = new HashMap<>();
        map.put("q", 1);
        map.put("a", 1);
        map.put("b", 1);
        return map;
    }
}
