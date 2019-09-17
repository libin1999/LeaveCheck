package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.StudentInfo;



public interface StudentInfoDao {
	//ͨ��id���Ҷ�Ӧ��ѧ������
	public StudentInfo getStudentById(int id);
	//ͨ��idֵɾ��ѧ������
	public int deleteById(int id);
	//��ȡѧ����ȫ����Ϣ
	public List<StudentInfo> getStudentlist();
	//����ѧ����Ϣ
	public int addStudent(StudentInfo student);
	//�޸�ѧ����Ϣ
	public int updateStudentById(StudentInfo student);
	//ͨ��stu_number���Ҷ�Ӧ��ѧ������
	public StudentInfo getStudentByNumber(int number);

}
