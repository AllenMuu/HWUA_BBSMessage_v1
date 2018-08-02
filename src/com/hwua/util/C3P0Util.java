package com.hwua.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	// 创建一个管理连接池的对象，它会自动读取classes目录下的名字叫c3p0-config.xml的配置文件
	// 根据配置的参数会自动创建一个连接池，并管理连接池。
	private static ComboPooledDataSource cpds = new ComboPooledDataSource();

	public static ComboPooledDataSource getCpds() {
		return cpds;
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = cpds.getConnection();// 从连接池中获取一个连接对象
			System.out.println("success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 释放连接对象到连接池中
	 * @param conn
	 */
	public static void closeConnection(Connection conn){
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
