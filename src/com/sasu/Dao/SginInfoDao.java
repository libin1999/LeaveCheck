package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.SginInfo;

public interface SginInfoDao {
	public SginInfo getSginInfoById(int id);
	//通过id查找对应的班主任审核对象	
	public int deleteById(int id);
	//通过id值删除班主任审核对象
	public List<SginInfo> getSginInfoList();
	//获取全部信息
	public int addSginInfo(SginInfo sgin);
	//添加班主任审核信息	
	public int updateSginInfo(SginInfo sgin);
	//修改班主任审核信息	

}
