package com.sasu.entiy;

public class TimeSheet {	//ѧ��������Ϣ		��ʤ
	private int id;
	private int teacher_id;	//�Ǹ���ʦ��¼�Ŀ�����Ϣ
	private TeacherInfo teacher;	//��Ӧ�Ľ�ʦ����
	private int studnet_id;	//��¼���Ǹ�ѧ��
	private StudentInfo student;	//��ѧ������
	private String record_item;		//�ü�¼������
	private String record_date;		//��¼����ʱ��
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
