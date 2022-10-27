package com.zyc.mvc.controller.old;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelAndViewController {

    /*
        SpringMVC提供了域许多对象用来共享数据
        1.ModelAndView  Model用来向request存放数据     View用于设置视图,实现页面跳转
        2.Model
        3.ModelMap
        4.Map<String,Object>
        底层都是BindingAwareModelMap类型,关系如下所示
            public class BindingAwareModelMap extends ExtendedModelMap {}
            public class ExtendedModelMap extends ModelMap implements Model {}
            public class ModelMap extends LinkedHashMap<String, Object> {}
     */

    @RequestMapping("/model/view")
    public ModelAndView mav(){
        ModelAndView mav = new ModelAndView("hello");
        mav.addObject("modelandview", "this is modelandview");
        return mav;
    }

    @RequestMapping("/model")
    public String model(Model model){
        model.addAttribute("model", "model value");
        return "hello";
    }

    @RequestMapping("/modelmap")
    public String modelmap(ModelMap modelMap){
        modelMap.addAttribute("modelmap", "model map value");
//        return "forward:/model";//不能被渲染
        return "hello";
    }

}
