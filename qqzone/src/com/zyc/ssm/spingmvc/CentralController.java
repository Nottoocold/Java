package com.zyc.ssm.spingmvc;

import com.zyc.ssm.ioc.BeanFactory;
import com.zyc.ssm.utils.StringUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @Description 中央控制器 负责解析URL 映射到不同Controller中不同的方法<br/>并根据放回置进行不同的响应处理
 * @Author zyc
 * @Date 2022/8/7 下午6:13
 */
@WebServlet(name = "CentralController", value = "*.do")
public class CentralController extends ViewBaseServlet {
    private static final String RESPONSETAG = "redirect:";
    private static BeanFactory beanFactory = null;

    /**
     * 初始化 中央控制器从上下文获取IOC容器
     *
     * @throws ServletException ..
     */
    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext servletContext = getServletContext();
        //从作用域中获取ioc容器
        Object beanFactoryOBJ = servletContext.getAttribute("beanFactory");
        if (beanFactoryOBJ != null) {
            beanFactory = (BeanFactory) beanFactoryOBJ;
        } else {
            throw new CentralControllerException("从作用域中获取IOC容器失败!");
        }
    }

    /**
     * 根据请求中的操作符号,获取IOC容器中映射到的实例,通过反射调用指定的方法,并根据返回值进行不同的响应
     *
     * @param request  ..
     * @param response ..
     * @throws IOException ..
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //根据请求路径创建分别映射到不同对象  /fruit.do
        String servletPath = request.getServletPath();
        int lastIndexOf = servletPath.lastIndexOf('.');
        servletPath = servletPath.substring(1, lastIndexOf);
        Object o = beanFactory.getBean(servletPath);
        //获取请求操作符(即Controller中对应的Method)
        String opt = request.getParameter("opt");
        if (StringUtil.isEmpty(opt))
            opt = "index";
        try {
            Method[] methods = o.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (opt.equals(method.getName())) {
                    //1.统一获取请求参数
                    //1-1.获取当前方法的参数，返回参数数组
                    Parameter[] parameters = method.getParameters();
                    //1-2.parameterValues 用来承载参数的值
                    Object[] parameterValues = new Object[parameters.length];
                    for (int i = 0; i < parameters.length; i++) {
                        Parameter parameter = parameters[i];
                        String parameterName = parameter.getName();
                        //如果参数名是request,response,session 那么就不是通过请求中获取参数的方式了
                        if ("request".equals(parameterName)) {
                            parameterValues[i] = request;
                        } else if ("response".equals(parameterName)) {
                            parameterValues[i] = response;
                        } else if ("session".equals(parameterName)) {
                            parameterValues[i] = request.getSession();
                        } else {
                            //从请求中获取参数值
                            String parameterValue = request.getParameter(parameterName);
                            String typeName = parameter.getType().getName();
                            Object parameterObj = parameterValue;
                            if (parameterObj != null) {
                                if ("java.lang.Integer".equals(typeName)) {
                                    parameterObj = Integer.parseInt(parameterValue);
                                }
                            }
                            parameterValues[i] = parameterObj;
                        }
                    }
                    //2.controller组件中的方法调用
                    method.setAccessible(true);
                    Object returnObj = method.invoke(o, parameterValues);
                    //3.视图处理
                    String methodReturnStr = (String) returnObj;
                    if (methodReturnStr.startsWith(RESPONSETAG)) {        //比如：  redirect:login.do
                        String redirectStr = methodReturnStr.substring(RESPONSETAG.length());
                        response.sendRedirect(redirectStr);
                    } else {
                        super.processTemplate(methodReturnStr, request, response);    //
                    }
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new CentralControllerException("中央控制器出错");
        }
    }
}
