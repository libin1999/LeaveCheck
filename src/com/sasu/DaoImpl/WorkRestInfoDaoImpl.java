package com.sasu.DaoImpl;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sasu.Dao.WorkRestInfoDao;
import com.sasu.Util.JDBC;
import com.sasu.entiy.WorkRestInfo;

public class WorkRestInfoDaoImpl implements WorkRestInfoDao {

	@Override
	public WorkRestInfo getWorkRestById(int id) {
		// TODO Auto-generated method stub
		WorkRestInfo workRest = null;
		String sql="select * from work_rest where id = ?";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql, id);
		try {
			if(rst.next()) {
				workRest=new WorkRestInfo();
				workRest.setId(rst.getInt("id"));
				workRest.setSequence(rst.getString("sequence"));
				workRest.setTime_begin(rst.getString("time_begin"));
				workRest.setTime_end(rst.getString("time_end"));
				workRest.setSemester(rst.getString("semester"));
				
			}
			conn.close();
			JDBC.pre.close();
			rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return workRest;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		int result=-1;
		String sql="delete from work_rest where id = ?";
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
	public int addWorkRest(WorkRestInfo workrest) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="insert into work_rest(sequence,time_begin,time_end,semester) values(?,?,?,?)";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, workrest.getSequence(),workrest.getTime_begin(),workrest.getTime_end(),workrest.getSemester());
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
	public int updateWorkRest(WorkRestInfo workrest) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="update work_rest set sequence=?,time_begin=?,time_end=?,semester=?";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql,workrest.getSequence(),workrest.getTime_begin(),workrest.getTime_end(),workrest.getSemester(),workrest.getId());
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
	public List<WorkRestInfo> getWorkRestInfolist() {
		// TODO Auto-generated method stub
		List<WorkRestInfo> list = new ArrayList<>();
		WorkRestInfo workRest = null;
		String sql="select * from work_rest ";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql);
		try {
			while(rst.next()) {
				workRest=new WorkRestInfo();
				workRest.setId(rst.getInt("id"));
				workRest.setSequence(rst.getString("sequence"));
				workRest.setTime_begin(rst.getString("time_begin"));
				workRest.setTime_end(rst.getString("time_end"));
				workRest.setSemester(rst.getString("semester"));									
				list.add(workRest);
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
