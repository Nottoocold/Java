package org.mybatis.interceptor;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.mybatis.vo.PageItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Properties;

/**
 * @author zyc
 * @date 2022/10/22
 */
@Intercepts(
        @Signature(
                type = StatementHandler.class,
                method = "prepare",
                args = {Connection.class, Integer.class}
        )
)
public class PagePlugin implements Interceptor {
    private static final Logger log = LoggerFactory.getLogger(PagePlugin.class);
    private static final String HANDLER = "delegate.";
    private static final String HANDLER_SQL_NO = HANDLER + "boundSql";
    private static final String HANDLER_SQL = HANDLER_SQL_NO + ".";
    private Properties properties;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        // originObject-> RoutingStatementHandler
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        // 因为可能target被多个拦截器拦截 所以需要分离代理对象链 从而获取真正的代理目标
        while (metaObject.hasGetter("h")) {
            Object h = metaObject.getValue("h");
            metaObject = SystemMetaObject.forObject(h);
        }
        // 分离出目标
        while (metaObject.hasGetter("target")) {
            Object target = metaObject.getValue("target");
            metaObject = SystemMetaObject.forObject(target);
        }

        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue(HANDLER + "mappedStatement");

        String regex = properties.getProperty("pageRegex");

        String id = mappedStatement.getId();

        if (id.matches(regex)) {

            int total = getTotalSize(statementHandler, (Connection) invocation.getArgs()[0]);

            BoundSql boundSql = statementHandler.getBoundSql();

            if (total <= 0) {
                metaObject.setValue(HANDLER_SQL + "sql", "select 1 from dual");
                metaObject.setValue(HANDLER_SQL + "parameterMappings", Collections.EMPTY_LIST);
                metaObject.setValue(HANDLER_SQL + "parameterObject", null);
            } else {

                PageItem pageItem = (PageItem) metaObject.getValue(HANDLER_SQL + "parameterObject." + properties.getProperty("paramName"));

                String sql = buildPageSql(boundSql.getSql(), pageItem);

                metaObject.setValue(HANDLER_SQL + "sql", sql);

                pageItem.setTotal(total);

                log.debug("{}", pageItem);
            }
        }

        return invocation.proceed();
    }

    private int getTotalSize(StatementHandler statementHandler, Connection conn) {
        ParameterHandler parameterHandler = statementHandler.getParameterHandler();

        String countSql = getCountSql(statementHandler.getBoundSql().getSql());

        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            psmt = conn.prepareStatement(countSql);
            parameterHandler.setParameters(psmt);
            rs = psmt.executeQuery();
            if (rs.next()) {
                // 设置总记录数
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (psmt != null) {
                    psmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    private String getCountSql(String originalSql) {
        // 统一转换为小写
        originalSql = originalSql.trim().toLowerCase();

        // 判断是否存在 limit 标识
        int limitIdx = originalSql.indexOf("limit");
        if (limitIdx > -1) {
            originalSql = originalSql.substring(0, limitIdx);
        }

        boolean distinctExist = originalSql.contains("distinct");
        boolean groupExist = originalSql.contains("group by");
        if (distinctExist || groupExist) {
            return "select count(1) from (" + originalSql + ") temp_count";
        }

        // 去掉 order by
        //boolean orderExist = originalSql.contains("order by");
        int orderByIdx = originalSql.indexOf("order by");
        if (orderByIdx > -1) {
            originalSql = originalSql.substring(0, orderByIdx);
        }

        // todo   left join还可以考虑优化
        int indexFrom = originalSql.indexOf("from");
        return "select count(*)  " + originalSql.substring(indexFrom);
    }

    private String buildPageSql(String sql, PageItem pageItem) {
        return sql + " limit " + (pageItem.getCurPage() - 1) * (pageItem.getPageSize()) + "," + pageItem.getPageSize();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler)
            return Plugin.wrap(target, this);
        return target;
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
