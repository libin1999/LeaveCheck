package com.sasu.DaoImpl;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sasu.Dao.LeaveInfoDao;
import com.sasu.Dao.ParentReplyDao;
import com.sasu.Util.JDBC;
import com.sasu.entiy.ParentReply;

public class ParentReplyDaoImpl implements ParentReplyDao {

	@Override
	public ParentReply getParentReplyById(int id) {
		// TODO Auto-generated method stub
		ParentReply parReply = null;
		String sql="select * from parent_reply where id = ?";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql, id);
		try {
			if(rst.next()) {
				parReply = new ParentReply();
				parReply.setId(rst.getInt("id"));
				parReply.setContent(rst.getString("content"));
				int leaveId = rst.getInt("leave_id");
				parReply.setLeave_id(leaveId);
				LeaveInfoDao dao = new LeaveInfoDaoImpl(); 
				parReply.setLeave(dao.getLeaveById(leaveId));
				parReply.setRecord_time(rst.getString("record_time"));				
				
			}
			conn.close();
			JDBC.pre.close();
			rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parReply;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		int result=-1;
		String sql="delete from parent_reply where id = ?";
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
	public int addParentReply(ParentReply parReply) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="insert into parent_reply(content,leave_id,record_time) values(?,?,?)";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, parReply.getContent(),parReply.getLeave_id(),parReply.getRecord_time());
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
	public int updateParentReply(ParentReply parReply) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="update parent_reply set content=?,leave_id=?,record_time=? where id = ?";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, parReply.getContent(),parReply.getLeave_id(),parReply.getRecord_time(),parReply.getId());
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
	public List<ParentReply> getParentReplylist() {
		// TODO Auto-generated method stub
		List<ParentReply> list = new ArrayList<>();
		ParentReply parReply = null;
		String sql="select * from parent_reply ";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql);
		try {
			if(rst.next()) {
				parReply = new ParentReply();
				parReply.setId(rst.getInt("id"));
				parReply.setContent(rst.getString("content"));
				int leaveId = rst.getInt("leave_id");
				parReply.setLeave_id(leaveId);
				LeaveInfoDao dao = new LeaveInfoDaoImpl(); 
				parReply.setLeave(dao.getLeaveById(leaveId));
				parReply.setRecord_time(rst.getString("record_time"));				
				list.add(parReply);
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
