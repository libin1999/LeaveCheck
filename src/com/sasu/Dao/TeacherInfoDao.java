package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.TeacherInfo;

public interface TeacherInfoDao {
		//ͨ��id���Ҷ�Ӧ�İ༶����
		public TeacherInfo getTeacherById(int id);
		//ͨ��idֵɾ���༶����
		public int deleteById(int id);
		//��ȡ�༶��ȫ����Ϣ
		public List<TeacherInfo> getTeacherlist();
		//z���Ӱ༶��Ϣ
		public int addTeacher(TeacherInfo teacher);
		//�޸İ༶��Ϣ
		public int updateTeacherById(TeacherInfo teacher);
}
