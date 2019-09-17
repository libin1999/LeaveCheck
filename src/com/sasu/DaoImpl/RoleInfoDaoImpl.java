package com.sasu.DaoImpl;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sasu.Dao.RoleInfoDao;
import com.sasu.Dao.RoleUrlInfoDao;
import com.sasu.Util.JDBC;
import com.sasu.entiy.RoleInfo;
import com.sasu.entiy.RoleUrlInfo;

public class RoleInfoDaoImpl implements RoleInfoDao {

	@Override
	public RoleInfo getRoleInfoById(int id) {
		// TODO Auto-generated method stub
		RoleInfo role=null;
		String sql="select * from role_info where id = ?";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql, id);
		try {
			if(rst.next()) {
				role=new RoleInfo();
				role.setId(id);
				role.setRole_name(rst.getString("role_name"));
				role.setRole_info(rst.getString("role_info"));
				RoleUrlInfoDao rudao=new RoleUrlInfoDaoImpl();
				List<RoleUrlInfo> info=rudao.getRoleUrlInfolist();
				for(RoleUrlInfo roleUrl:info) {
					if(roleUrl.getRole_id()!=id)
						info.remove(roleUrl);
				}
				role.setList(info);
			}
			conn.close();
			JDBC.pre.close();
			rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return role;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="delete from role_info where id =?";
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
	public List<RoleInfo> getRoleInfolist() {
		// TODO Auto-generated method stub
		List<RoleInfo> list=new ArrayList<>();
		RoleInfo role=null;
		String sql="select * from role_info";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql);
		try {
			while(rst.next()) {
				role=new RoleInfo();
				role.setId(rst.getInt("id"));
				role.setRole_name(rst.getString("role_name"));
				role.setRole_info(rst.getString("role_info"));
				list.add(role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addRoleInfo(RoleInfo role) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="insert into role_info(role_name,role_info) values(?,?)";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql,role.getRole_name(),role.getRole_info());
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
	public int updateRoleInfo(RoleInfo role) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql="update role_info set role_name = ?,role_info = ? where id = ?";
		Connection conn=JDBC.getConnection();
		result = JDBC.executeUpdate(conn, sql, role.getRole_name(),role.getRole_info(),role.getId());
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
