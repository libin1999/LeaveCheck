package com.sasu.DaoImpl;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sasu.Dao.ClazzInfoDao;
import com.sasu.Dao.LessonInfoDao;
import com.sasu.Dao.TeacherInfoDao;
import com.sasu.Util.JDBC;
import com.sasu.entiy.LessonInfo;

public class LessonInfoDaoImpl implements LessonInfoDao {

	@Override
	public LessonInfo getLessonById(int id) {
		// TODO Auto-generated method stub
		LessonInfo lesson = null;
		String sql="select * from lesson_info where id = ?";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql, id);
		try {
			if(rst.next()) {
				lesson=new LessonInfo();
				lesson.setId(rst.getInt("id"));
				lesson.setCourse_id(rst.getInt("course_id"));
				int clazzid=rst.getInt("course_id");
				lesson.setClazz_id(clazzid);
				ClazzInfoDao clazzdao=new ClazzInfoDaoImpl();
				lesson.setClazz(clazzdao.getClazzById(clazzid));
				int teacherid=rst.getInt("teacher_id");
				lesson.setTeacher_id(teacherid);
				TeacherInfoDao teacherdao=new TeacherInfoDaoImpl();
				lesson.setTeacher(teacherdao.getTeacherById(teacherid));
				lesson.setWeekday(rst.getInt("weekday"));
				lesson.setClazz_begin(rst.getInt("clazz_begin"));
				lesson.setClazz_over(rst.getInt("clazz_over"));
				lesson.setClazz_room(rst.getString("clazz_room"));
			}
			conn.close();
			JDBC.pre.close();
			rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lesson;
	
	
		
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		int result=-1;
		String sql="delete from lesson_info where id = ?";
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
	public int addLesson(LessonInfo lesson) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="insert into lesson_info(course_id,clazz_id,teacher_id,weekday,clazz_begin,clazz_over,clazz_room) values(?,?,?,?,?,?,?)";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, lesson.getCourse_id(),lesson.getClazz_id(),lesson.getTeacher_id(),lesson.getWeekday(),lesson.getClazz_begin(),lesson.getClazz_over(),lesson.getClazz_room());
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
	public int updateLesson(LessonInfo lesson) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="update lesson_info set course_id=?,clazz_id=?,teacher_id=?,weekday=?,clazz_begin=?,clazz_over=?,clazz_room=? where id = ?";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, lesson.getCourse_id(),lesson.getClazz_id(),lesson.getTeacher_id(),lesson.getWeekday(),lesson.getClazz_begin(),lesson.getClazz_over(),lesson.getClazz_room(),lesson.getId());
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
	public List<LessonInfo> getLessonlist() {
		// TODO Auto-generated method stub
		List<LessonInfo> list=new ArrayList<>();
		LessonInfo lesson = null;
		String sql="select * from lesson_info ";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql);
		try {
			if(rst.next()) {
				lesson=new LessonInfo();
				lesson.setId(rst.getInt("id"));
				lesson.setCourse_id(rst.getInt("course_id"));
				int clazzid=rst.getInt("course_id");
				lesson.setClazz_id(clazzid);
				ClazzInfoDao clazzdao=new ClazzInfoDaoImpl();
				lesson.setClazz(clazzdao.getClazzById(clazzid));
				int teacherid=rst.getInt("teacher_id");
				lesson.setTeacher_id(teacherid);
				TeacherInfoDao teacherdao=new TeacherInfoDaoImpl();
				lesson.setTeacher(teacherdao.getTeacherById(teacherid));
				lesson.setWeekday(rst.getInt("weekday"));
				lesson.setClazz_begin(rst.getInt("clazz_begin"));
				lesson.setClazz_over(rst.getInt("clazz_over"));
				lesson.setClazz_room(rst.getString("clazz_room"));								
				list.add(lesson);
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
