package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.CollegeInfo;;

public interface CollegeInfoDao {
		//通过id查找对应的学院对象
		public CollegeInfo getCollegeById(int id); 
		//通过id值删除学院对象
		public int deleteById(int id);
		//获取所有的全部信息
		public List<CollegeInfo> getCollegelist();
		//z增加学院信息
		public int addCollege(CollegeInfo college);
		//修改学院信息
		public int updateCollege(CollegeInfo college);
}
