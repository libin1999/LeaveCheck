package com.sasu.Dao;

import java.util.List;


import com.sasu.entiy.LessonInfo;

public interface LessonInfoDao {
	//ͨ��id���Ҷ�Ӧ�Ķ���
			public LessonInfo getLessonById(int id); 
			//ͨ��idֵɾ������
			public int deleteById(int id);
			//������Ϣ
			public int addLesson(LessonInfo lesson);
			//�޸���Ϣ
			public int updateLesson(LessonInfo lesson);
			
			public List<LessonInfo> getLessonlist();
}
