package com.sasu.DaoImpl;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sasu.Dao.ClazzInfoDao;
import com.sasu.Dao.StudentInfoDao;
import com.sasu.Dao.UserInfoDao;
import com.sasu.Util.JDBC;
import com.sasu.entiy.StudentInfo;


public class StudentInfoDaoImpl implements StudentInfoDao{

	@Override
	public StudentInfo getStudentById(int id) {
		// TODO Auto-generated method stub
		StudentInfo student=null;
		String sql="select * from student_info where id=?";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql, id);
		
		try {
			if(rst.next()) {
				student=new StudentInfo();
				int studentId=rst.getInt("id");
				student.setId(studentId);
				student.setStu_number(rst.getString("stu_number"));//数据库字段需要修改
				UserInfoDao userDao=new UserInfoDaoImpl();
				student.setUser(userDao.getUserById(studentId));
				student.setStu_name(rst.getString("stu_name"));
				student.setStu_sex(rst.getString("stu_sex"));
				student.setStu_phone(rst.getString("stu_phone"));
				student.setStu_grade(rst.getInt("stu_grade"));
				student.setStu_photofile(rst.getString("stu_photofile"));
				student.setStu_parent(rst.getString("stu_parent"));
				student.setStu_parentPhone(rst.getString("stu_parent_phone"));
				int clazzId=rst.getInt("clazz_id");
				student.setClazz_id(clazzId);
				ClazzInfoDao clazzDao=new ClazzInfoDaoImpl();
				student.setClazz(clazzDao.getClazzById(clazzId));
				}
			conn.close();
			JDBC.pre.close();
			rst.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		int result=-1;
		String sql="delete from student_info where id = ?";
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
	public List<StudentInfo> getStudentlist() {
		// TODO Auto-generated method stub
		List<StudentInfo> list=new ArrayList<>();
		StudentInfo student=null;
		String sql="select * from student_info";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql);
		
		try {
			if(rst.next()) {
				student=new StudentInfo();
				int studentId=rst.getInt("id");
				student.setId(studentId);
				student.setStu_number(rst.getString("stu_number"));//数据库字段需要修改
				UserInfoDao userDao=new UserInfoDaoImpl();
				student.setUser(userDao.getUserById(studentId));
				student.setStu_name(rst.getString("stu_name"));
				student.setStu_sex(rst.getString("stu_sex"));
				student.setStu_phone(rst.getString("stu_phone"));
				student.setStu_grade(rst.getInt("stu_grade"));
				student.setStu_photofile(rst.getString("stu_photofile"));
				student.setStu_parent(rst.getString("stu_parent"));
				student.setStu_parentPhone(rst.getString("stu_parent_phone"));
				int clazzId=rst.getInt("clazz_id");
				student.setClazz_id(clazzId);
				ClazzInfoDao clazzDao=new ClazzInfoDaoImpl();
				student.setClazz(clazzDao.getClazzById(clazzId));
			}
			conn.close();
			JDBC.pre.close();
			rst.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return list;
	}

	@Override
	public int addStudent(StudentInfo student) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="insert into student_info(stu_number,stu_name,stu_sex,stu_phone,stu_grade,stu_photofile,stu_parent,"
				+ "stu_parentPhone,clazz_id) values(?,?,?,?,?,?,?,?,?)";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, student.getStu_number(),student.getStu_name(),student.getStu_sex(),
				student.getStu_phone(),student.getStu_grade(),student.getStu_photofile(),student.getStu_parent(),
				student.getStu_parentPhone(),student.getClazz_id());
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
	public int updateStudentById(StudentInfo student) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="update student_info set stu_number=?,stu_name=?,stu_sex=?,stu_phone=?,stu_grade=?,stu_photofile=?,"
				+ "stu_parent=?,stu_parentPhone=?,clazz_id=? where id = ?";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, student.getStu_number(),student.getStu_name(),student.getStu_sex(),
				student.getStu_phone(),student.getStu_grade(),student.getStu_photofile(),student.getStu_parent(),
				student.getStu_parentPhone(),student.getClazz_id());
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
	public StudentInfo getStudentByNumber(int number) {
		// TODO Auto-generated method stub
		StudentInfo student=null;
		String sql="select * from student_info where stu_number=?";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql, number);
		
		try {
			if(rst.next()) {
				student=new StudentInfo();
				int studentId=rst.getInt("id");
				student.setId(studentId);
				student.setStu_number(rst.getString("stu_number"));//数据库字段需要修改
				UserInfoDao userDao=new UserInfoDaoImpl();
				student.setUser(userDao.getUserById(studentId));
				student.setStu_name(rst.getString("stu_name"));
				student.setStu_sex(rst.getString("stu_sex"));
				student.setStu_phone(rst.getString("stu_phone"));
				student.setStu_grade(rst.getInt("stu_grade"));
				student.setStu_photofile(rst.getString("stu_photofile"));
				student.setStu_parent(rst.getString("stu_parent"));
				student.setStu_parentPhone(rst.getString("stu_parent_phone"));
				int clazzId=rst.getInt("clazz_id");
				student.setClazz_id(clazzId);
				ClazzInfoDao clazzDao=new ClazzInfoDaoImpl();
				student.setClazz(clazzDao.getClazzById(clazzId));
				}
			conn.close();
			JDBC.pre.close();
			rst.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return student;
	}
	
}
