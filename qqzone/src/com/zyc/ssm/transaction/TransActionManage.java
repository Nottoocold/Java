package com.zyc.ssm.transaction;

import com.zyc.ssm.utils.MYJDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/9 10:43
 */
public class TransActionManage {

    public static void begin() throws SQLException {
        Connection conn = MYJDBCUtil.getConnection();
        conn.setAutoCommit(false);
//        System.out.println(conn);
    }

    public static void commit() throws SQLException {
        Connection conn = MYJDBCUtil.getConnection();
//        System.out.println(conn);
        conn.commit();
        MYJDBCUtil.close();
    }

    public static void rollback() throws SQLException {
        Connection conn = MYJDBCUtil.getConnection();
//        System.out.println(conn);
        conn.rollback();
        MYJDBCUtil.close();
    }
}
