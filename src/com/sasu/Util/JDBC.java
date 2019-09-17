package com.sasu.Util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {
	public static PreparedStatement pre;
	/**
	 * 静态内部内，用于加载驱动。
	 */
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("加载驱动异常");
		}
	}
	/**
	 * 获取连接
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/stu_leave?characterEncoding=UTF-8", "root", "lb199902");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("链接数据库异常");
		}
		return conn;
		
	}
	/**
	 * 该方法能防止sql注入，执行executeQuery()方法，主要用于select操作
	 * 返回Result结果集
	 * @param conn
	 * @param sql
	 * @param para
	 * @return
	 */
	public static ResultSet executeQuery(Connection conn,String sql,Object...para) {
		ResultSet resultSet=null;
		pre=null;
		try {
			pre=conn.prepareStatement(sql);
			for(int i=0;i<para.length;i++) {
				Object obj=para[i];
				pre.setString(i+1, obj.toString());
			}
			resultSet=pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库executeSQL有问题");
			e.printStackTrace();
		}
		return resultSet;
//		if(conn!=null && !conn.isClosed()) {
//			
//		}
	}
	/**
	 * 改方法能够防止sql注入，使用PreparedStatement的对象
	 * 调用executeUpdate()方法，主要对数据库的数据进行 INSERT、UPDATE 或 DELETE 的操作
	 * @param conn
	 * @param sql
	 * @param objects
	 * @return
	 */
	public static int executeUpdate(Connection conn, String sql, Object...objects) {
		// TODO Auto-generated method stub
		int returnCount=0;
		try {
			pre=conn.prepareStatement(sql);
			for(int i=0;i<objects.length;i++) {
				String s=objects[i]+"";
				pre.setString(i+1, s);
			}
			returnCount=pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnCount;
	}
}
