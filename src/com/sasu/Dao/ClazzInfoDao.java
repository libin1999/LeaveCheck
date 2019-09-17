package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.ClazzInfo;

public interface ClazzInfoDao {
	//通过id查找对应的班级对象
	public ClazzInfo getClazzById(int id); 
	//通过id值删除班级对象
	public int deleteById(int id);
	//获取班级的全部信息
	public List<ClazzInfo> getClazzlist();
	//z增加班级信息
	public int addClazz(ClazzInfo clazz);
	//修改班级信息
	public int updateClazz(ClazzInfo clazz);
}
