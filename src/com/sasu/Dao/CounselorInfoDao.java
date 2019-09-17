package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.CounselorInfo;

public interface CounselorInfoDao {
	public CounselorInfo getCounselorById(int id);
	//通过id查找年级辅导员对象
	public int deleteById(int id);
	//通过id值删除年级辅导员对象
	public List<CounselorInfo> getCounselorList();
	//获取全部信息
	public int addCounselor(CounselorInfo counselor);
	//添加年级辅导员信息
	public int updateCounselor(CounselorInfo counselor);
	//修改年级辅导员信息

}
