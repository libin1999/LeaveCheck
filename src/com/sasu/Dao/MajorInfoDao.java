package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.MajorInfo;

public interface MajorInfoDao {
		//通过id查找对应的专业对象
		public MajorInfo getMajorById(int id); 
		//通过id值删除专业对象
		public int deleteById(int id);
		//获取所有专业的全部信息
		public List<MajorInfo> getMajorlist();
		//z增加专业信息
		public int addMajor(MajorInfo major);
		//修改专业信息
		public int updateMajor(MajorInfo major);
}
