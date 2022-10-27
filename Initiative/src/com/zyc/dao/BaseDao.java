package com.zyc.dao;

import com.zyc.utils.MYJDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/2 上午10:40
 */
public final class BaseDao {

    //使用apache开源工具依赖DBUtils操作数据库
    private static final QueryRunner runner = new QueryRunner();

    /**
     * run insert/update/delete SqlStatement
     *
     * @param sql  sql info
     * @param args ?
     * @return -1 if appear SQLException</br>else return affected rows of table
     */
    public static int updateSQL(String sql, Object... args) {
        Connection conn = MYJDBCUtil.getConnection();
        int row = -1;
        try {
            row = runner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BaseDaoException("BaseDao RuntimeException..");
        }
        return row;
    }

    /**
     * @param objectType BeanHandler的类型
     * @param sql        sql info
     * @param args       ?
     * @param <T>        generic
     * @return specified Class<T> Object if refer to success,else return null
     */
    public static <T> T queryForOne(Class<T> objectType, String sql, Object... args) {
        Connection conn = MYJDBCUtil.getConnection();
        T ret = null;
        try {
            ret = runner.query(conn, sql, new BeanHandler<T>(objectType), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BaseDaoException("BaseDao RuntimeException..");
        }
        return ret;
    }

    public static <T> List<T> queryForList(Class<T> objectType, String sql, Object... args) {
        Connection conn = MYJDBCUtil.getConnection();
        List<T> ret = null;
        try {
            ret = runner.query(conn, sql, new BeanListHandler<T>(objectType), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BaseDaoException("BaseDao RuntimeException..");
        }
        return ret;
    }

    /**
     * 执行返回一行一列的SQL语句
     *
     * @param sql  sql
     * @param args ?
     * @return Object of T
     */
    public static Object queryForSingleValue(String sql, Object... args) {
        Connection conn = MYJDBCUtil.getConnection();
        Object ret = null;
        try {
            ret = runner.query(conn, sql, new ScalarHandler<>(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BaseDaoException("BaseDao RuntimeException..");
        }
        return ret;
    }
}
