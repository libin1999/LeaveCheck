package com.sasu.DaoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sasu.Dao.CollegeInfoDao;
import com.sasu.Dao.CollegeLeaderInfoDao;
import com.sasu.Dao.UserInfoDao;
import com.sasu.Util.JDBC;
import com.sasu.entiy.CollegeLeaderInfo;

public class CollegeLeaderInfoDaoImpl implements CollegeLeaderInfoDao {

	@Override
	public CollegeLeaderInfo getCollegeLeaderInfoById(int id) {
		CollegeLeaderInfo collegeLeader=null;
		String sql="select * from college_leader_info where id = ? ";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql, id);
		 try {
			if (rst.next()) {
				collegeLeader=new CollegeLeaderInfo();
				collegeLeader.setId(rst.getInt("id"));
				
				int userId=rst.getInt("l_account");
				collegeLeader.setLeader_account(userId);
				UserInfoDao userDao=new UserInfoDaoImpl();
				collegeLeader.setUser(userDao.getUserById(userId));
				
				collegeLeader.setLeader_name(rst.getString("l_name"));
				collegeLeader.setLeader_sex(rst.getString("l_sex"));
				
				int collegeId=rst.getInt("college_id");
				collegeLeader.setCollege_id(collegeId); 
				CollegeInfoDao collegeDao=new CollegeInfoDaoImpl();
				collegeLeader.setCollege(collegeDao.getCollegeById(collegeId));
			}
			conn.close();
			JDBC.pre.close();
			rst.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
		return collegeLeader;
	}

	@Override
	public int deleteById(int id) {

		int result=0;
		String sql="delete from college_leader_info where id=? ";
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
	public List<CollegeLeaderInfo> getCollegeLeaderlist() {

		List<CollegeLeaderInfo> list=new ArrayList<>();
		CollegeLeaderInfo collegeLeader=null;
		String sql="select * from college_leader_info";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql);
		try {
			while(rst.next()) {
				collegeLeader=new CollegeLeaderInfo();
				collegeLeader.setId(rst.getInt("id"));
				
				int userId=rst.getInt("l_account");
				collegeLeader.setLeader_account(userId);
				UserInfoDao userDao=new UserInfoDaoImpl();
				collegeLeader.setUser(userDao.getUserById(userId));
				
				collegeLeader.setLeader_name(rst.getString("l_name"));
				collegeLeader.setLeader_sex(rst.getString("l_sex"));
				
				int collegeId=rst.getInt("college_id");
				collegeLeader.setCollege_id(collegeId); 
				CollegeInfoDao collegeDao=new CollegeInfoDaoImpl();
				collegeLeader.setCollege(collegeDao.getCollegeById(collegeId));
				list.add(collegeLeader);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addCollegeLeader(CollegeLeaderInfo collegeLeader) {

		int result=0;
		String sql="insert into college_leader_info(l_account,l_name,l_sex,college_id) values(?,?,?,?)";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, collegeLeader.getLeader_account(),collegeLeader.getLeader_name(),collegeLeader.getLeader_sex(),collegeLeader.getCollege_id());
		try {
			conn.close();
			JDBC.pre.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateCollegeLeader(CollegeLeaderInfo collegeLeader) {
		int result=0;
		String sql="update college_leader_info set l_account=?,l_name=?,l_sex=?,college_id=? where id=?";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, collegeLeader.getLeader_account(),collegeLeader.getLeader_name(),collegeLeader.getLeader_sex(),collegeLeader.getCollege_id(),collegeLeader.getId());
		try {
			conn.close();
			JDBC.pre.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return result;
	}

}
