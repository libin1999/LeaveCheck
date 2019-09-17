package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.TimeSheet;



public interface TimeSheetInfoDao {
	//通过id查找对应的考勤表
	public TimeSheet getTimeSheetById(int id);
	//通过id值删除考勤表
	public int deleteById(int id);
	//获取考勤表的全部信息
	public List<TimeSheet> getTimelist();
	//增加考勤表的信息
	public int addTimeSheet(TimeSheet time);
	//修改考勤表信息
	public int updateTimeSheetById(TimeSheet time);
	
	

}
