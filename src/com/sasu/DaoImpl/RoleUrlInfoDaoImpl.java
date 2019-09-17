package com.sasu.DaoImpl;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sasu.Dao.RoleUrlInfoDao;
import com.sasu.Util.JDBC;
import com.sasu.entiy.RoleUrlInfo;

public class RoleUrlInfoDaoImpl implements RoleUrlInfoDao {

	@Override
	public RoleUrlInfo getRoleUrlInfoById(int id) {
		// TODO Auto-generated method stub
		RoleUrlInfo roleurl=null;
		String sql="select * from role_url where id = ?";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql, id);
		try {
			if(rst.next()) {
				roleurl=new RoleUrlInfo();
				roleurl.setId(id);
				roleurl.setRole_id(rst.getInt("role_id"));
				roleurl.setUrl_id(rst.getInt("url_id"));
			}
			conn.close();
			JDBC.pre.close();
			rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roleurl;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="delete from role_url where id =?";
		Connection conn=JDBC.getConnection();
		result = JDBC.executeUpdate(conn, sql, id);
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
	public List<RoleUrlInfo> getRoleUrlInfolist() {
		// TODO Auto-generated method stub
		List<RoleUrlInfo> list=new ArrayList<>();
		RoleUrlInfo roleurl=null;
		String sql="select * from role_url";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql);
		try {
			while(rst.next()) {
				roleurl=new RoleUrlInfo();
				roleurl.setId(rst.getInt("id"));
				roleurl.setRole_id(rst.getInt("role_id"));
				roleurl.setUrl_id(rst.getInt("url_id"));
				list.add(roleurl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addRoleUrlInfo(RoleUrlInfo role) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="insert into role_url(role_id,url_id) values(?,?)";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql,role.getRole_id(),role.getUrl_id());
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
	public int updateRoleUrlInfo(RoleUrlInfo role) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql="update role_info set role_id = ?,url_id = ? where id = ?";
		Connection conn=JDBC.getConnection();
		result = JDBC.executeUpdate(conn, sql, role.getRole_id(),role.getUrl_id(),role.getId());
		try {
			conn.close();
			JDBC.pre.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
