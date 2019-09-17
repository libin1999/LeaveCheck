package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.TeacherInfo;

public interface TeacherInfoDao {
		//通过id查找对应的班级对象
		public TeacherInfo getTeacherById(int id);
		//通过id值删除班级对象
		public int deleteById(int id);
		//获取班级的全部信息
		public List<TeacherInfo> getTeacherlist();
		//z增加班级信息
		public int addTeacher(TeacherInfo teacher);
		//修改班级信息
		public int updateTeacherById(TeacherInfo teacher);
}
