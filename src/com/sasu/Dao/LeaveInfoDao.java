package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.LeaveInfo;



public interface LeaveInfoDao {
	//通过id查找对应的教师对象
	public LeaveInfo getLeaveById(int id);
	//通过id值删除教师对象
	public int deleteById(int id);
	//获取教师的全部信息
	public List<LeaveInfo> getLeavelist();
	//增加教师信息
	public int addLeave(LeaveInfo leave);
	//修改教师信息
	public int updateLeaveById(LeaveInfo leave);

}
