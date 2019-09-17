package com.sasu.entiy;

public class TeacherInfo {	//教师信息		罗胜
	private int id;
	private String teacher_number;	//教职工编号
	private UserInfo user;			//账户密码信息对象
	private String teacher_name;	//教职工姓名
	private String teacher_sex;		//性别
	private String teacher_level;	//技术职称
	private int college_id;			//所属学院的编号
	private CollegeInfo college;	//所属学院的对象
	
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeacher_number() {
		return teacher_number;
	}
	public void setTeacher_number(String teacher_number) {
		this.teacher_number = teacher_number;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getTeacher_sex() {
		return teacher_sex;
	}
	public void setTeacher_sex(String teacher_sex) {
		this.teacher_sex = teacher_sex;
	}
	public String getTeacher_level() {
		return teacher_level;
	}
	public void setTeacher_level(String teacher_level) {
		this.teacher_level = teacher_level;
	}
	public int getCollege_id() {
		return college_id;
	}
	public void setCollege_id(int college_id) {
		this.college_id = college_id;
	}
	public CollegeInfo getCollege() {
		return college;
	}
	public void setCollege(CollegeInfo college) {
		this.college = college;
	}
	

}
