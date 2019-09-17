package com.sasu.DaoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sasu.Dao.LeaveInfoDao;
import com.sasu.Dao.SginInfoDao;
import com.sasu.Util.JDBC;
import com.sasu.entiy.SginInfo;

public class SginInfoDaoImpl implements SginInfoDao{

	@Override
	public SginInfo getSginInfoById(int id) {

		SginInfo sgin=null;
		String sql="select * from sgin_info where id=?";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql, id);
		try {
			if (rst.next()) {
				sgin=new SginInfo();
				sgin.setId(rst.getInt("id"));
				sgin.setContent(rst.getString("content"));
				
				int leaveId=rst.getInt("leave_id");
				sgin.setLeave_id(leaveId);
				LeaveInfoDao leaveDao=new LeaveInfoDaoImpl();
				sgin.setLeave(leaveDao.getLeaveById(leaveId));
				
				sgin.setRecord_time(rst.getString("record_time"));
			}
			conn.close();
			JDBC.pre.close();
			rst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sgin;
	}

	@Override
	public int deleteById(int id) {

		int result=0;
		String sql="delete from sgin_info where id=?";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, id);
		try {
			conn.close();
			JDBC.pre.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<SginInfo> getSginInfoList() {
		List<SginInfo> list=new ArrayList<>();
		SginInfo sgin=null;
		String sql="select * from sgin_info";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql);
		try {
			while (rst.next()) {
				sgin=new SginInfo();
				sgin.setId(rst.getInt("id"));
				sgin.setContent(rst.getString("content"));
				
				int leaveId=rst.getInt("leave_id");
				sgin.setLeave_id(leaveId);
				LeaveInfoDao leaveDao=new LeaveInfoDaoImpl();
				sgin.setLeave(leaveDao.getLeaveById(leaveId));
				
				sgin.setRecord_time(rst.getString("record_time"));
				list.add(sgin);
			}conn.close();
			JDBC.pre.close();
			rst.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addSginInfo(SginInfo sgin) {	
		int result=0;
		String  sql="insert into sgin_info(content,leave_id,record_time) values (?,?,?)";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, sgin.getContent(),sgin.getLeave_id(),sgin.getRecord_time());
		try {
			conn.close();
			JDBC.pre.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateSginInfo(SginInfo sgin) {
		int result=0;
		String sql="update sgin_info set content=?,leave_id=?,record_time=? where id=?";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, sgin.getContent(),sgin.getLeave_id(),sgin.getRecord_time(),sgin.getId());
		try {
			conn.close();
			JDBC.pre.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
