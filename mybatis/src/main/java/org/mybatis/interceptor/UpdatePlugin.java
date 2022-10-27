package org.mybatis.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author zyc
 * @date 2022/10/22
 */
@Intercepts(
        value = {
                @Signature(
                        type = Executor.class,
                        method = "update",
                        args = {MappedStatement.class, Object.class}),
        }
)
public class UpdatePlugin implements Interceptor {
    private static final Logger log = LoggerFactory.getLogger(UpdatePlugin.class);

    /*
        拦截的逻辑
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.debug("拦截器了.Executor#update()方法");
        log.debug("代理的目标对象target ={}", invocation.getTarget());
        log.debug("需要代理的方法method ={}", invocation.getMethod());
        log.debug("args ={}", Arrays.toString(invocation.getArgs()));
        return invocation.proceed();
    }

    /*
        在这里可以决断是否需要拦截该方法而决定要返回一个什么样的对象(是普通对象还是代理对象)
     */
    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        }
        return target;
    }

    @Override
    public void setProperties(Properties properties) {

    }


}
