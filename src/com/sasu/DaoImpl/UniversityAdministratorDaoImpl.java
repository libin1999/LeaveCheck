package com.sasu.DaoImpl;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sasu.Dao.UniversityAdministratorDao;
import com.sasu.Util.JDBC;
import com.sasu.entiy.UniversityAdministrator;

public class UniversityAdministratorDaoImpl implements UniversityAdministratorDao {

	public UniversityAdministrator getUniAdminById(int id) {
		// TODO Auto-generated method stub
		UniversityAdministrator uniAdmin = null;
		String sql="select * from university_administrator where id = ?";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql, id);
		try {
			if(rst.next()) {
				uniAdmin=new UniversityAdministrator();
				uniAdmin.setId(rst.getInt("id"));
				uniAdmin.setAdmin_account(rst.getString("a_account"));
				uniAdmin.setAdmin_name(rst.getString("a_name"));		
				uniAdmin.setAdmin_sex(rst.getString("a_sex"));
				
			}
			conn.close();
			JDBC.pre.close();
			rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uniAdmin;
	
	}

	public int deleteById(int id) {
		// TODO Auto-generated method stub
		int result=-1;
		String sql="delete from university_administrator where id = ?";
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

	public int addUniAdmin(UniversityAdministrator uniAdmin) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="insert into university_administrator(a_account,a_name,a_sex) values(?,?,?)";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, uniAdmin.getAdmin_account(),uniAdmin.getAdmin_name(),uniAdmin.getAdmin_sex());
		try {
			conn.close();
			JDBC.pre.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}

	public int updateUniAdmin(UniversityAdministrator uniAdmin) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="update university_administrator set a_account=?,a_name=?,a_sex=? where id = ?";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, uniAdmin.getAdmin_account(),uniAdmin.getAdmin_name(),uniAdmin.getAdmin_sex(),uniAdmin.getId());
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
	public List<UniversityAdministrator> getUniversityAdministratorlist() {
		// TODO Auto-generated method stub
		List<UniversityAdministrator> list = new ArrayList<>();
		UniversityAdministrator uniAdmin = null;
		String sql="select * from university_administrator ";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql);
		try {
			if(rst.next()) {
				uniAdmin=new UniversityAdministrator();
				uniAdmin.setId(rst.getInt("id"));
				uniAdmin.setAdmin_account(rst.getString("a_account"));
				uniAdmin.setAdmin_name(rst.getString("a_name"));		
				uniAdmin.setAdmin_sex(rst.getString("a_sex"));
				list.add(uniAdmin);
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

}
