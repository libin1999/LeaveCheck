package com.sasu.Dao;

import java.util.List;


import com.sasu.entiy.CourseInfo;

public interface CourseInfoDao {
		//ͨ��id���Ҷ�Ӧ�Ķ���
		public CourseInfo getCourseById(int id); 
		//ͨ��idֵɾ������
		public int deleteById(int id);
		//���ӿγ���Ϣ
		public int addCourse(CourseInfo course);
		//�޸Ŀγ���Ϣ
		public int updateCourse(CourseInfo course);
		
		public List<CourseInfo> getCourselist();
}
