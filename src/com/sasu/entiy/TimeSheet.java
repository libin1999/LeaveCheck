package com.sasu.entiy;

public class TimeSheet {	//学生考勤信息		罗胜
	private int id;
	private int teacher_id;	//那个教师记录的考勤信息
	private TeacherInfo teacher;	//对应的教师对象
	private int studnet_id;	//记录了那个学生
	private StudentInfo student;	//该学生对象
	private String record_item;		//该记录的内容
	private String record_date;		//记录考勤时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public TeacherInfo getTeacher() {
		return teacher;
	}
	public void setTeacher(TeacherInfo teacher) {
		this.teacher = teacher;
	}
	public int getStudnet_id() {
		return studnet_id;
	}
	public void setStudnet_id(int studnet_id) {
		this.studnet_id = studnet_id;
	}
	public StudentInfo getStudent() {
		return student;
	}
	public void setStudent(StudentInfo student) {
		this.student = student;
	}
	public String getRecord_item() {
		return record_item;
	}
	public void setRecord_item(String record_item) {
		this.record_item = record_item;
	}
	public String getRecord_date() {
		return record_date;
	}
	public void setRecord_date(String record_date) {
		this.record_date = record_date;
	}
	

}
