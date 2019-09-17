package com.sasu.DaoImpl;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sasu.Dao.LeaveInfoDao;
import com.sasu.Dao.StudentInfoDao;
import com.sasu.Util.JDBC;
import com.sasu.entiy.LeaveInfo;


public class LeaveInfoDaoImpl implements LeaveInfoDao{

	@Override
	public LeaveInfo getLeaveById(int id) {
		// TODO Auto-generated method stub
		LeaveInfo leave=null;
		String sql="select * from leave_info where id=?";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql, id);
		
		try {
			if(rst.next()) {
				leave=new LeaveInfo();
				leave.setId(rst.getInt("id"));
				int studentId=rst.getInt("student_id");
				leave.setStudent_id(studentId);
				StudentInfoDao stuDao=new StudentInfoDaoImpl();
				leave.setStudent(stuDao.getStudentById(studentId));
				leave.setRecord_item(rst.getString("record_item"));
				leave.setLeave_reason(rst.getString("leave_reason"));
				leave.setLeave_begin(rst.getString("leave_begin"));
				leave.setLeave_end(rst.getString("leave_end"));
				leave.setRecord_status(rst.getInt("record_status"));
				leave.setRecord_date(rst.getString("record_date"));
			}
			conn.close();
			JDBC.pre.close();
			rst.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return leave;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		int result=-1;
		String sql="delete from leave_info where id = ?";
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
	public List<LeaveInfo> getLeavelist() {
		// TODO Auto-generated method stub
		List<LeaveInfo> list=new ArrayList<>();
		LeaveInfo leave=null;
		String sql="select * from leave_info";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql);
		
		try {
			if(rst.next()) {
				leave=new LeaveInfo();
				leave.setId(rst.getInt("id"));
				int studentId=rst.getInt("student_id");
				leave.setStudent_id(studentId);
				StudentInfoDao stuDao=new StudentInfoDaoImpl();
				leave.setStudent(stuDao.getStudentById(studentId));
				leave.setRecord_item(rst.getString("record_item"));
				leave.setLeave_reason(rst.getString("leave_reason"));
				leave.setLeave_begin(rst.getString("leave_begin"));
				leave.setLeave_end(rst.getString("leave_end"));
				leave.setRecord_status(rst.getInt("record_status"));
				leave.setRecord_date(rst.getString("record_date"));
				list.add(leave);
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
	public int addLeave(LeaveInfo leave) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="insert into leave_info(student_id,record_item,leave_reason,leave_begin,leave_end,record_status,record_date) values(?,?,?,?,?,?,?)";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, leave.getStudent_id(),leave.getRecord_item(),leave.getLeave_reason(),leave.getLeave_begin(),
				leave.getLeave_end(),leave.getRecord_status(),leave.getRecord_date());
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
	public int updateLeaveById(LeaveInfo leave) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="update leave_info set student_id=?,record_item=?,leave_reason=?,leave_begin=?,leave_end=?"
				+ "record_status=?,record_date=? where id = ?";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, leave.getStudent_id(),leave.getRecord_item(),leave.getLeave_reason(),leave.getLeave_begin(),
				leave.getLeave_end(),leave.getRecord_status(),leave.getRecord_date());
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
