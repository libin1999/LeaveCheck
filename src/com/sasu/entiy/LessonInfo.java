package com.sasu.entiy;

public class LessonInfo {		//授课信息		谭力
	private int id;
	private int course_id;	//课程编号
	private CourseInfo course;	//该课程的对象
	private int clazz_id;	//上课班级的编号
	private ClazzInfo clazz;	//上课班级的信息
	private int teacher_id;		//上课教室的id值
	private TeacherInfo teacher;	//上课老师信息
	private int weekday;	//上课是在星期几
	private int clazz_begin;	//上课从第几节开始
	private int clazz_over;		//上课到第几节结束
	private String clazz_room; //上课教室编号
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public CourseInfo getCourse() {
		return course;
	}
	public void setCourse(CourseInfo course) {
		this.course = course;
	}
	public int getClazz_id() {
		return clazz_id;
	}
	public void setClazz_id(int clazz_id) {
		this.clazz_id = clazz_id;
	}
	public ClazzInfo getClazz() {
		return clazz;
	}
	public void setClazz(ClazzInfo clazz) {
		this.clazz = clazz;
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
	public int getWeekday() {
		return weekday;
	}
	public void setWeekday(int weekday) {
		this.weekday = weekday;
	}
	public int getClazz_begin() {
		return clazz_begin;
	}
	public void setClazz_begin(int clazz_begin) {
		this.clazz_begin = clazz_begin;
	}
	public int getClazz_over() {
		return clazz_over;
	}
	public void setClazz_over(int clazz_over) {
		this.clazz_over = clazz_over;
	}
	public String getClazz_room() {
		return clazz_room;
	}
	public void setClazz_room(String clazz_room) {
		this.clazz_room = clazz_room;
	}
	

}
