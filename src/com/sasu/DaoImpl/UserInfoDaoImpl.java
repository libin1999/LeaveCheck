package com.sasu.DaoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sasu.Dao.RoleInfoDao;
import com.sasu.Dao.UserInfoDao;
import com.sasu.Util.JDBC;
import com.sasu.entiy.UserInfo;

public class UserInfoDaoImpl implements UserInfoDao {

	@Override
	public UserInfo getUserById(int id) {
		// TODO Auto-generated method stub
		UserInfo user=null;
		String sql="select * from user_info where id = ?";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql, id);
		try {
			if(rst.next()) {
				user=new UserInfo();
				user.setId(id);
				user.setUsername(rst.getString("username"));
				user.setPassword(rst.getString("password"));
				int roleid=rst.getInt("role_id");
				user.setRole(roleid);
				RoleInfoDao roledao=new RoleInfoDaoImpl();
				user.setRoleinfo(roledao.getRoleInfoById(roleid));
				
			}
			conn.close();
			JDBC.pre.close();
			rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="delete from user_info where id = ?";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, id);
		try {
			conn.close();
			JDBC.pre.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<UserInfo> getUserlist() {
		// TODO Auto-generated method stub
		List<UserInfo> list=new ArrayList<>();
		UserInfo user=null;
		String sql="select * from user_info";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql);
		try {
			while(rst.next()) {
				user=new UserInfo();
				user.setId(rst.getInt("id"));
				user.setUsername(rst.getString("username"));
				user.setPassword(rst.getString("password"));
				user.setRole(rst.getInt("role"));
				list.add(user);
			}
			conn.close();
			JDBC.pre.close();
			rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addMajor(UserInfo user) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="insert into user_info(username,password,role) values(?,?,?)";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, user.getUsername(),user.getPassword(),user.getRole());
		try {
			conn.close();
			JDBC.pre.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateMajor(UserInfo user) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="update user_info set username = ?,password = ?,role = ? where id =?";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, user.getUsername(),user.getPassword(),user.getRole(),user.getId());
		try {
			conn.close();
			JDBC.pre.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public UserInfo getUserByNumber(String number) {
		// TODO Auto-generated method stub
		UserInfo user=null;
		String sql="select * from user_info where username = ?";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql, number);
		try {
			if(rst.next()) {
				user=new UserInfo();
				user.setId(rst.getInt("id"));
				user.setUsername(rst.getString("username"));
				user.setPassword(rst.getString("password"));
				int roleid=rst.getInt("role_id");
				user.setRole(roleid);
				RoleInfoDao roledao=new RoleInfoDaoImpl();
				user.setRoleinfo(roledao.getRoleInfoById(roleid));
			}
			conn.close();
			JDBC.pre.close();
			rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
