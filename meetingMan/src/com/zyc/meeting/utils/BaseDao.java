package com.zyc.meeting.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	private static final String DRIVERNAME = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/meeting?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private static final String USERNAME = "root";
	private static final String USERPWD = "zyc0909";
	private static Connection conn = null;
	private static PreparedStatement ptmt = null;
	private static ResultSet rs = null;

	public Connection getConnection() {
		try {
			Class.forName(DRIVERNAME);
			conn = DriverManager.getConnection(URL, USERNAME, USERPWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/*
	 * 通用增删改操作
	 */
	public int update(String sql, Object... params) {
		int count = 0;
		try {
			conn = this.getConnection();
			ptmt = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ptmt.setObject(i + 1, params[i]);
				}
			}
			count = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	/*
	 * 通用查询操作
	 */
	public ResultSet query(String sql, Object... params) {
		try {
			conn = this.getConnection();
			ptmt = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ptmt.setObject(i + 1, params[i]);
				}
			}
			rs = ptmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}

			if (ptmt != null) {

				ptmt.close();
			}
			if (conn != null) {

				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
