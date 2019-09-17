package com.sasu.DaoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sasu.Dao.CollegeInfoDao;
import com.sasu.Dao.TeacherInfoDao;
import com.sasu.Dao.UserInfoDao;
import com.sasu.Util.JDBC;
import com.sasu.entiy.TeacherInfo;


public class TeacherInfoDaoImpl implements TeacherInfoDao{

	@Override
	public TeacherInfo getTeacherById(int id) {
		// TODO Auto-generated method stub
		TeacherInfo teacher=null;
		String sql="select * from teacher_info where id = ?";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql, id);
		try {
			if(rst.next()) {
				teacher=new TeacherInfo();
				int teacherId=rst.getInt("id");
				teacher.setId(teacherId);
				teacher.setTeacher_number(rst.getString("teacher_number"));//数据库字段需要修改
				UserInfoDao userDao=new UserInfoDaoImpl();
				teacher.setUser(userDao.getUserById(teacherId));
				teacher.setTeacher_name(rst.getString("teacher_name"));
				teacher.setTeacher_sex(rst.getString("teacher_sex"));
				teacher.setTeacher_level(rst.getString("teacher_level"));
				int collegeId=rst.getInt("college_id");
				CollegeInfoDao collegeDao=new CollegeInfoDaoImpl();
				teacher.setCollege(collegeDao.getCollegeById(collegeId));
				
			}
			conn.close();
			JDBC.pre.close();
			rst.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return teacher;
		
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		int result=-1;
		String sql="delete from teacher_info where id = ?";
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
	public List<TeacherInfo> getTeacherlist() {
		// TODO Auto-generated method stub
		List<TeacherInfo> list=new ArrayList<>();
		TeacherInfo teacher=null;
		String sql="select * from teacher_info";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql);
		try {
			while(rst.next()) {
				teacher=new TeacherInfo();
				int teacherId=rst.getInt("id");
				teacher.setId(teacherId);
				teacher.setTeacher_number(rst.getString("teacher_number"));
				UserInfoDao userDao=new UserInfoDaoImpl();
				teacher.setUser(userDao.getUserById(teacherId));
				teacher.setTeacher_name(rst.getString("teacher_name"));
				teacher.setTeacher_sex(rst.getString("teacher_sex"));
				teacher.setTeacher_level(rst.getString("teacher_level"));
				int collegeId=rst.getInt("college_id");
				CollegeInfoDao collegeDao=new CollegeInfoDaoImpl();
				teacher.setCollege(collegeDao.getCollegeById(collegeId));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addTeacher(TeacherInfo teacher) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="insert into teacher_info(teacher_number,teacher_name,teacher_sex,teacher_level,college_id) values(?,?,?,?,?)";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, teacher.getTeacher_number(),teacher.getTeacher_name(),
				teacher.getTeacher_sex(),teacher.getTeacher_level(),teacher.getCollege_id());
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
	public int updateTeacherById(TeacherInfo teacher) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="update teacher_info set teacher_number=?,teacher_name=?,teacher_sex=?,teacher_level=?,college_id=? where id = ?";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, teacher.getTeacher_number(),teacher.getTeacher_name(),
				teacher.getTeacher_sex(),teacher.getTeacher_level(),teacher.getCollege_id());
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
