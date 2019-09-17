package com.sasu.DaoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sasu.Dao.CollegeInfoDao;
import com.sasu.Util.JDBC;
import com.sasu.entiy.CollegeInfo;
import com.sasu.entiy.CourseInfo;

public class CollegeInfoDaoImpl implements CollegeInfoDao {

	@Override
	public List<CollegeInfo> getCollegelist() {
		// TODO Auto-generated method stub
		List<CollegeInfo> list = new ArrayList<>();
		CollegeInfo college = null;
		String sql="select * from college_info";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql);
		try {
			while(rst.next()) {
				college=new CollegeInfo();
				college.setId(rst.getInt("id"));
				college.setName(rst.getString("name"));
				college.setSequence(rst.getInt("sequence"));
				list.add(college);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		int result=-1;
		String sql="delete from college_info where id = ?";
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
	public int addCollege(CollegeInfo college) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="insert into college_info(name,sequence) values(?,?)";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql,college.getName(),college.getSequence());
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
	public int updateCollege(CollegeInfo college) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="update  college_info set name=?,sequence=? where id = ?";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql,college.getName(),college.getSequence(),college.getId());
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
	public CollegeInfo getCollegeById(int id) {
		// TODO Auto-generated method stub
		CollegeInfo college = null;
		String sql="select * from college_info where id = ?";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql, id);
		try {
			if(rst.next()) {
				college=new CollegeInfo();
				college.setId(rst.getInt("id"));
				college.setName(rst.getString("name"));
				college.setSequence(rst.getInt("sequence"));								
				
			}
			conn.close();
			JDBC.pre.close();
			rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return college;
	
	}

}
