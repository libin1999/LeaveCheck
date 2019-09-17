package com.sasu.Dao;

import java.util.List;


import com.sasu.entiy.LessonInfo;

public interface LessonInfoDao {
	//通过id查找对应的对象
			public LessonInfo getLessonById(int id); 
			//通过id值删除对象
			public int deleteById(int id);
			//增加信息
			public int addLesson(LessonInfo lesson);
			//修改信息
			public int updateLesson(LessonInfo lesson);
			
			public List<LessonInfo> getLessonlist();
}
