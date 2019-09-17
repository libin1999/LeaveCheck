package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.CollegeLeaderInfo;

public interface CollegeLeaderInfoDao {

	public CollegeLeaderInfo getCollegeLeaderInfoById(int id);
	//通过id查找对应学院领导对象
	public int deleteById(int id);
	//通过id的值删除学院领导对象
	public List<CollegeLeaderInfo> getCollegeLeaderlist();
	//获取全部信息
	public int addCollegeLeader(CollegeLeaderInfo collegeLeader);
	//添加学院领导信息
	public int updateCollegeLeader(CollegeLeaderInfo collegeLeader);
	//修改学院领导信息
	
}
