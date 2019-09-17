package com.sasu.DaoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.sasu.Dao.CollegeInfoDao;
import com.sasu.Dao.CounselorInfoDao;
import com.sasu.Util.JDBC;
import com.sasu.entiy.CounselorInfo;

public class CounselorInfoDaoImpl implements CounselorInfoDao {

	@Override
	public CounselorInfo getCounselorById(int id) {
		CounselorInfo counselor=null;
		String sql="select * from counselor_info where id=?";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql, id);
		try {
			if (rst.next()) {
				counselor=new CounselorInfo();
				counselor.setId(rst.getInt("id"));
				counselor.setCounselor_number(rst.getString("c_work_num"));
				counselor.setCounselor_name(rst.getString("c_name"));
				counselor.setCounselor_sex(rst.getString("c_sex"));
				counselor.setPhone(rst.getString("c_phone"));
				counselor.setGard(rst.getString("c_gard"));
				int collegeId=rst.getInt("college_id");
				counselor.setCollege_id(collegeId);
				CollegeInfoDao collegeDao=new CollegeInfoDaoImpl();
				counselor.setCollege(collegeDao.getCollegeById(collegeId));;
			}
			conn.close();
			JDBC.pre.close();
			rst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return counselor;
	}

	@Override
	public int deleteById(int id) {
		int result=0;
		String sql="delete from counselor_info where id=?";
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
	public List<CounselorInfo> getCounselorList() {
		List<CounselorInfo> list=new ArrayList<>();
		CounselorInfo counselor=null;
		String sql="select * from counselor_info";
		Connection conn=JDBC.getConnection();
		ResultSet rst=JDBC.executeQuery(conn, sql);
		try {
			while (rst.next()) {
				counselor=new CounselorInfo();
				counselor.setId(rst.getInt("id"));
				counselor.setCounselor_number(rst.getString("c_work_num"));
				counselor.setCounselor_name(rst.getString("c_name"));
				counselor.setCounselor_sex(rst.getString("c_sex"));
				counselor.setPhone(rst.getString("c_phone"));
				counselor.setGard(rst.getString("c_gard"));
				int collegeId=rst.getInt("college_id");
				counselor.setCollege_id(collegeId);
				CollegeInfoDao collegeDao=new CollegeInfoDaoImpl();
				counselor.setCollege(collegeDao.getCollegeById(collegeId));;
			}
			conn.close();
			JDBC.pre.close();
			rst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addCounselor(CounselorInfo counselor) {
		int result=0;
		String sql="insert into counselor_info(c_work_num,c_name,c_sex,college_id) values (?,?,?,?)";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, counselor.getCounselor_number(),counselor.getCounselor_name(),counselor.getCounselor_sex(),counselor.getCollege_id());
		try {
			conn.close();
			JDBC.pre.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateCounselor(CounselorInfo counselor) {
		int result=0;
		String sql="update counselor_info set c_work_num=?,c_name=?,c_sex=?,college_id=? where id=?";
		Connection conn=JDBC.getConnection();
		result=JDBC.executeUpdate(conn, sql, counselor.getCounselor_number(),counselor.getCounselor_name(),counselor.getCounselor_sex(),counselor.getCollege_id(),counselor.getId());
		try {
			conn.close();
			JDBC.pre.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
