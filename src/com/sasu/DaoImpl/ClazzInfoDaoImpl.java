package com.sasu.DaoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sasu.Dao.ClazzInfoDao;
import com.sasu.Dao.MajorInfoDao;
import com.sasu.Dao.TeacherInfoDao;
import com.sasu.Util.JDBC;
import com.sasu.entiy.ClazzInfo;

public class ClazzInfoDaoImpl implements ClazzInfoDao{

	@Override
	public ClazzInfo getClazzById(int id) {
		// TODO Auto-generated method stub
		ClazzInfo clazz=null;
		String sql="select * from clazz_info where id = ?";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql, id);
		try {
			if(rst.next()) {
				clazz=new ClazzInfo();
				clazz.setId(rst.getInt("id"));
				clazz.setClazz_name(rst.getString("clazz_name"));
				clazz.setClazz_sequence(rst.getInt("clazz_sequence"));
				int teacherId=rst.getInt("teacher_id");
				clazz.setTeacher_id(teacherId);
				TeacherInfoDao teacherdao=new TeacherInfoDaoImpl();
				clazz.setTeacher(teacherdao.getTeacherById(teacherId));
				int majorid=rst.getInt("major_id");
				clazz.setMajor_id(majorid);
				MajorInfoDao majordao=new MajorInfoDaoImpl();
				clazz.setMajor(majordao.getMajorById(majorid));
			}
			conn.close();
			JDBC.pre.close();
			rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clazz;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		int result=-1;
		String sql="delete from clazz_info where id = ?";
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
	public List<ClazzInfo> getClazzlist() {
		// TODO Auto-generated method stub
		List<ClazzInfo> list=new ArrayList<>();
		ClazzInfo clazz=null;
		String sql="select * from clazz_info";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql);
		try {
			while(rst.next()) {
				clazz=new ClazzInfo();
				clazz.setId(rst.getInt("id"));
				clazz.setClazz_name(rst.getString("clazz_name"));
				clazz.setClazz_sequence(rst.getInt("clazz_sequence"));
				int teacherId=rst.getInt("teacher_id");
				clazz.setTeacher_id(teacherId);
				TeacherInfoDao teacherdao=new TeacherInfoDaoImpl();
				clazz.setTeacher(teacherdao.getTeacherById(teacherId));
				int majorid=rst.getInt("major_id");
				clazz.setMajor_id(majorid);
				MajorInfoDao majordao=new MajorInfoDaoImpl();
				clazz.setMajor(majordao.getMajorById(majorid));
				list.add(clazz);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addClazz(ClazzInfo clazz) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="insert into clazz_info(clazz_name,clazz_sequence,teacher_id,major_id) values(?,?,?,?)";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, clazz.getClazz_name(),clazz.getClazz_sequence(),clazz.getTeacher_id(),clazz.getMajor_id());
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
	public int updateClazz(ClazzInfo clazz) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="update clazz_info set clazz_name=?,clazz_sequence=?,teacher_id=? where id = ?";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, clazz.getClazz_name(),clazz.getClazz_sequence(),clazz.getTeacher_id(),clazz.getId());
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
