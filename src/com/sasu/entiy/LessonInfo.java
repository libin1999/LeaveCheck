package com.sasu.entiy;

public class LessonInfo {		//�ڿ���Ϣ		̷��
	private int id;
	private int course_id;	//�γ̱��
	private CourseInfo course;	//�ÿγ̵Ķ���
	private int clazz_id;	//�Ͽΰ༶�ı��
	private ClazzInfo clazz;	//�Ͽΰ༶����Ϣ
	private int teacher_id;		//�Ͽν��ҵ�idֵ
	private TeacherInfo teacher;	//�Ͽ���ʦ��Ϣ
	private int weekday;	//�Ͽ��������ڼ�
	private int clazz_begin;	//�Ͽδӵڼ��ڿ�ʼ
	private int clazz_over;		//�Ͽε��ڼ��ڽ���
	private String clazz_room; //�Ͽν��ұ��
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
