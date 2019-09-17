package com.sasu.Dao;

import java.util.List;


import com.sasu.entiy.CourseInfo;

public interface CourseInfoDao {
		//通过id查找对应的对象
		public CourseInfo getCourseById(int id); 
		//通过id值删除对象
		public int deleteById(int id);
		//增加课程信息
		public int addCourse(CourseInfo course);
		//修改课程信息
		public int updateCourse(CourseInfo course);
		
		public List<CourseInfo> getCourselist();
}
