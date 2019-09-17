package com.sasu.DaoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sasu.Dao.CollegeInfoDao;
import com.sasu.Dao.MajorInfoDao;
import com.sasu.Util.JDBC;
import com.sasu.entiy.MajorInfo;

public class MajorInfoDaoImpl implements MajorInfoDao {

	@Override
	public MajorInfo getMajorById(int id) {
		// TODO Auto-generated method stub
		MajorInfo major=null;
		String sql="select * from major_info where id = ?";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql, id);
		try {
			if(rst.next()) {
				major=new MajorInfo();
				major.setId(id);
				int collegeid=rst.getInt("college_id");
				major.setCollege_id(collegeid);
				CollegeInfoDao dao=new CollegeInfoDaoImpl();
				major.setCollege(dao.getCollegeById(collegeid));
				major.setMajor_name(rst.getString("major_name"));
				major.setMajor_semeters(rst.getString("major_semeters"));
				major.setMajor_sequence(rst.getString("major_sequence"));
				major.setMajor_type(rst.getString("major_type"));
			}
			conn.close();
			JDBC.pre.close();
			rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return major;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="delete from major_info where id = ?";
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
	public List<MajorInfo> getMajorlist() {
		// TODO Auto-generated method stub
		List<MajorInfo> list=new ArrayList<>();
		MajorInfo major=null;
		String sql="select * from major_info";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql);
		try {
			while(rst.next()) {
				major=new MajorInfo();
				major.setId(rst.getInt("id"));
				int collegeid=rst.getInt("college_id");
				major.setCollege_id(collegeid);
				CollegeInfoDao dao=new CollegeInfoDaoImpl();
				major.setCollege(dao.getCollegeById(collegeid));
				major.setMajor_name(rst.getString("major_name"));
				major.setMajor_semeters(rst.getString("major_semeters"));
				major.setMajor_sequence(rst.getString("major_sequence"));
				major.setMajor_type(rst.getString("major_type"));
				list.add(major);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addMajor(MajorInfo major) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="inset into major_info(college_id,major_name,major_semeters,major_sequence,"
				+ "major_type) values(?,?,?,?)";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, major.getCollege_id(),
				major.getMajor_name(),major.getMajor_semeters(),major.getMajor_sequence());
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
	public int updateMajor(MajorInfo major) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="update major_info set college_id = ?,major_name = ?,"
				+ "major_semeters = ?,major_sequence = ?,major_type = ? where id = ?";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, major.getCollege_id(),major.getMajor_name(),major.getMajor_semeters(),
				major.getMajor_sequence(),major.getMajor_type(),major.getId());
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
