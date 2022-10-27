package com.zyc.ssm.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Description JDBC工具类
 * @Author zyc
 * @Date 2022/8/2 上午10:20
 */
public class MYJDBCUtil {
    private static DruidDataSource dataSource;
    private static final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<>();

    private MYJDBCUtil() {
    }

    static {
        try {
            Properties pro = new Properties();
            ClassLoader classLoader = MYJDBCUtil.class.getClassLoader();
            InputStream stream = classLoader.getResourceAsStream("druid.properties");
            pro.load(stream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = THREAD_LOCAL.get();
        if (conn == null) {
            try {
                conn = dataSource.getConnection();
                THREAD_LOCAL.set(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static void close() throws SQLException {
        Connection conn = THREAD_LOCAL.get();
        if (conn == null) {
            return;
        }
        if (!conn.isClosed()) {
            conn.close();
            THREAD_LOCAL.set(null);
        }
    }
}
