package com.sasu.DaoImpl;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sasu.Dao.StudentInfoDao;
import com.sasu.Dao.TeacherInfoDao;
import com.sasu.Dao.TimeSheetInfoDao;
import com.sasu.Util.JDBC;
import com.sasu.entiy.TimeSheet;



public class TimeSheetInfoDaoImpl implements TimeSheetInfoDao{

	@Override
	public TimeSheet getTimeSheetById(int id) {
		// TODO Auto-generated method stub
		TimeSheet time=null;
		String sql="select * from time_sheet where id = ?";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql, id);
		try {
			if(rst.next()) {
				time=new TimeSheet();
				time.setId(rst.getInt("id"));
				int teacherId=rst.getInt("teacher_id");
				time.setTeacher_id(teacherId);
				TeacherInfoDao teerDao=new TeacherInfoDaoImpl();
				time.setTeacher(teerDao.getTeacherById(teacherId));
				int studentId=rst.getInt("student_id");
				time.setStudnet_id(studentId);
				StudentInfoDao stuDao=new StudentInfoDaoImpl();
				time.setStudent(stuDao.getStudentById(studentId));
				time.setRecord_item(rst.getString("record_item"));
				time.setRecord_date(rst.getString("record_date"));
			}
			conn.close();
			JDBC.pre.close();
			rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		int result=-1;
		String sql="delete from time_sheet where id = ?";
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
	public List<TimeSheet> getTimelist() {
		// TODO Auto-generated method stub
		List<TimeSheet> list=new ArrayList<>();
		TimeSheet time=null;
		String sql="select * from time_sheet";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql);
		try {
			while(rst.next()) {
				time=new TimeSheet();
				time.setId(rst.getInt("id"));
				int teacherId=rst.getInt("teacher_id");
				time.setTeacher_id(teacherId);
				TeacherInfoDao teerDao=new TeacherInfoDaoImpl();
				time.setTeacher(teerDao.getTeacherById(teacherId));
				int studentId=rst.getInt("student_id");
				time.setStudnet_id(studentId);
				StudentInfoDao stuDao=new StudentInfoDaoImpl();
				time.setStudent(stuDao.getStudentById(studentId));
				time.setRecord_item(rst.getString("record_item"));
				time.setRecord_date(rst.getString("record_date"));
				list.add(time);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addTimeSheet(TimeSheet time) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="insert into time_sheet(teacher_id,student_id,record_item,record_date) values(?,?,?,?)";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, time.getTeacher_id(),time.getStudnet_id(),time.getRecord_item(),time.getRecord_date());
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
	public int updateTimeSheetById(TimeSheet time) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="update time_sheet set teacher_id=?,student_id=?,record_item=?,record_date=? where id = ?";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, time.getTeacher_id(),time.getStudnet_id(),time.getRecord_item(),time.getRecord_date());
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
