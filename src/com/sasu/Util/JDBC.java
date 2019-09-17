package com.sasu.Util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {
	public static PreparedStatement pre;
	/**
	 * ��̬�ڲ��ڣ����ڼ���������
	 */
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���������쳣");
		}
	}
	/**
	 * ��ȡ����
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/stu_leave?characterEncoding=UTF-8", "root", "lb199902");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�������ݿ��쳣");
		}
		return conn;
		
	}
	/**
	 * �÷����ܷ�ֹsqlע�룬ִ��executeQuery()��������Ҫ����select����
	 * ����Result�����
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
			System.out.println("���ݿ�executeSQL������");
			e.printStackTrace();
		}
		return resultSet;
//		if(conn!=null && !conn.isClosed()) {
//			
//		}
	}
	/**
	 * �ķ����ܹ���ֹsqlע�룬ʹ��PreparedStatement�Ķ���
	 * ����executeUpdate()��������Ҫ�����ݿ�����ݽ��� INSERT��UPDATE �� DELETE �Ĳ���
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
