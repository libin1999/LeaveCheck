package com.sasu.DaoImpl;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sasu.Dao.CourseInfoDao;
import com.sasu.Util.JDBC;
import com.sasu.entiy.CourseInfo;

public class CourseInfoDaoImpl implements CourseInfoDao {

	@Override
	public CourseInfo getCourseById(int id) {
		// TODO Auto-generated method stub
		CourseInfo course = null;
		String sql="select * from course_info where id = ?";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql, id);
		try {
			if(rst.next()) {
				course=new CourseInfo();
				course.setId(rst.getInt("id"));
				course.setCourse_name(rst.getString("c_name"));
				course.setCoursse_semester(rst.getString("c_semester"));									
			}
			conn.close();
			JDBC.pre.close();
			rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return course;
	
	
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		int result=-1;
		String sql="delete from course_info where id = ?";
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
	public int addCourse(CourseInfo course) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="insert into course_info(c_name,c_semester) values(?,?)";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, course.getCourse_name(),course.getCoursse_semester());
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
	public int updateCourse(CourseInfo course) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="update course_info set c_name=?,c_semester=? where id = ?";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, course.getCourse_name(),course.getCoursse_semester(),course.getId());
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
	public List<CourseInfo> getCourselist() {
		// TODO Auto-generated method stub
		List<CourseInfo> list=new ArrayList<>();
		CourseInfo course = null;
		String sql="select * from course_info";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql);
		try {
			while(rst.next()) {
				course=new CourseInfo();
				course.setId(rst.getInt("id"));
				course.setCourse_name(rst.getString("c_name"));
				course.setCoursse_semester(rst.getString("c_semester"));
				list.add(course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
