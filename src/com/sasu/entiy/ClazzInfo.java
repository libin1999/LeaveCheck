package com.sasu.entiy;

public class ClazzInfo {	//�༶��Ϣ		���
	private int id;
	private String clazz_name;	//�༶����
	private int clazz_sequence; //�༶������ֵ
	private int major_id;
	private MajorInfo major;
	private int teacher_id;	//�����α�š����ʦ���Ӧ
	private TeacherInfo teacher;	//��ʦ����
	public TeacherInfo getTeacher() {
		return teacher;
	}
	public void setTeacher(TeacherInfo teacher) {
		this.teacher = teacher;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClazz_name() {
		return clazz_name;
	}
	public void setClazz_name(String clazz_name) {
		this.clazz_name = clazz_name;
	}
	public int getClazz_sequence() {
		return clazz_sequence;
	}
	public void setClazz_sequence(int clazz_sequence) {
		this.clazz_sequence = clazz_sequence;
	}
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public int getMajor_id() {
		return major_id;
	}
	public void setMajor_id(int major_id) {
		this.major_id = major_id;
	}
	public MajorInfo getMajor() {
		return major;
	}
	public void setMajor(MajorInfo major) {
		this.major = major;
	}
}
