package com.zyc.servlet.controller;

import com.zyc.pojo.Fruit;
import com.zyc.pojo.PageBean;
import com.zyc.service.FruitService;
import com.zyc.utils.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/7 下午1:44
 */

public class FruitController {

    private static FruitService<Fruit> FRUIT_SERVICE = null;

    /*
        默认执行方法
     */
    private String index(HttpServletRequest request) {
        int curPage = 1;
        int numPerPage = 5;
        String curPageNo = request.getParameter("pageNo");
        if (StringUtil.isNotEmpty(curPageNo)) {
            curPage = Integer.parseInt(curPageNo);
        }
        String pageSize = request.getParameter("pageSize");
        if (StringUtil.isNotEmpty(pageSize)) {
            numPerPage = Integer.parseInt(pageSize);
        }
        PageBean<Fruit> pageBean = FRUIT_SERVICE.selectByPage(curPage, numPerPage);
        HttpSession session = request.getSession();
        session.setAttribute("curPageNo", curPage);
        session.setAttribute("pageCount", pageBean.getPageTotal());
        session.setAttribute("fruits", pageBean.getData());
        return "index";
    }

    private String upt(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Fruit f = Fruit.get(parameterMap);
        Fruit fruit = FRUIT_SERVICE.update(f);
        if (fruit != null) {
            request.setAttribute("fruit", fruit);
        }
        return "redirect:fruit";
    }

    private String selone(HttpServletRequest request) {
        String fid = request.getParameter("id");
        if (StringUtil.isNotEmpty(fid)) {
            Integer id = Integer.parseInt(fid);
            Fruit fruit = FRUIT_SERVICE.selectOne(id);
            if (fruit != null) {
                request.setAttribute("fruit", fruit);
//                super.processTemplate("edit", request, response);// /edit.html
            }
        }
        return "edit";
    }

    private String del(HttpServletRequest request) {
        String id = request.getParameter("id");
        String str = "";
        if (StringUtil.isNotEmpty(id)) {
            int row = FRUIT_SERVICE.deleteByIds(new Integer[]{Integer.parseInt(id)});
            if (row > 0) {
                str = "redirect:fruit";
                return str;
            }
//                response.sendRedirect("http://localhost:9090/com.zyc/fruit.do");
        }
        return str;
    }

    private String add(HttpServletRequest request) {
        String str = "";
        Map<String, String[]> parameterMap = request.getParameterMap();
        int row = FRUIT_SERVICE.insert(Fruit.get(parameterMap));
        if (row >= 0) {
            str = "redirect:fruit";
            return str;
        }
//            response.sendRedirect("http://localhost:9090/com.zyc/fruit.do");
        return str;
    }
}
