package com.sasu.DaoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sasu.Dao.OptUrlDao;
import com.sasu.Util.JDBC;
import com.sasu.entiy.OptUrl;

public class OptUrlDaoImpl implements OptUrlDao {

	@Override
	public OptUrl getOptUrlById(int id) {
		// TODO Auto-generated method stub
		OptUrl url=null;
		String sql="select * from opt_url where id = ?";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql, id);
		try {
			if(rst.next()) {
				url=new OptUrl();
				url.setId(id);
				url.setIntroduction(rst.getString("introduction"));
				url.setTitle(rst.getString("title"));
				url.setParent_id(rst.getInt("parent_id"));
				url.setUrl(rst.getString("url"));
			}
			conn.close();
			JDBC.pre.close();
			rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="delete from opt_url where id =?";
		Connection conn=JDBC.getConnection();
		result = JDBC.executeUpdate(conn, sql, id);
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
	public List<OptUrl> getOptUrllist() {
		// TODO Auto-generated method stub
		List<OptUrl> list=new ArrayList<>();
		OptUrl url=null;
		String sql="select * from opt_url";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql);
		try {
			while(rst.next()) {
				url=new OptUrl();
				url.setId(rst.getInt("id"));
				url.setIntroduction(rst.getString("introduction"));
				url.setTitle(rst.getString("title"));
				url.setParent_id(rst.getInt("parent_id"));
				url.setUrl(rst.getString("url"));
				list.add(url);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addOptUrl(OptUrl opturl) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="insert into opt_url(title,introduction,parent_id,url) values(?,?,?,?)";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, opturl.getTitle(),opturl.getIntroduction(),
				opturl.getParent_id(),opturl.getUrl());
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
	public int updateOptUrl(OptUrl opturl) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql="update opt_url set title = ?,introduction = ?,parent_id =?,url = ? where id = ?";
		Connection conn=JDBC.getConnection();
		result = JDBC.executeUpdate(conn, sql, opturl.getTitle(),opturl.getIntroduction(),
				opturl.getParent_id(),opturl.getUrl(),opturl.getId());
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
	public List<OptUrl> getSubmMeanus(int parent) {
		// TODO Auto-generated method stub
		List<OptUrl> list=new ArrayList<>();
		String sql="select * from opt_url where parent_id=?";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql, parent);
		OptUrl url=null;
		try {
			while(rst.next()) {
				url=new OptUrl();
				url.setId(rst.getInt("id"));
				url.setIntroduction(rst.getString("introduction"));
				url.setTitle(rst.getString("title"));
				url.setParent_id(rst.getInt("parent_id"));
				url.setUrl(rst.getString("url"));
				list.add(url);
			}
			conn.close();
			rst.close();
			JDBC.pre.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
