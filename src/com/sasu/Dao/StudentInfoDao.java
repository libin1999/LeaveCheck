package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.StudentInfo;



public interface StudentInfoDao {
	//通过id查找对应的学生对象
	public StudentInfo getStudentById(int id);
	//通过id值删除学生对象
	public int deleteById(int id);
	//获取学生的全部信息
	public List<StudentInfo> getStudentlist();
	//增加学生信息
	public int addStudent(StudentInfo student);
	//修改学生信息
	public int updateStudentById(StudentInfo student);
	//通过stu_number查找对应的学生对象
	public StudentInfo getStudentByNumber(int number);

}
