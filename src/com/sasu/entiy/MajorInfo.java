package com.sasu.entiy;

public class MajorInfo {		//专业信息		李斌
	private int id;
	private String major_name;	//专业名称
	private String major_sequence;	//专业的排序值
	private String major_type;	//专业类型
	private String major_semeters;	//学习的学期数
	private int college_id;		//专业开设在哪个学院
	private CollegeInfo college;	//专业开设在学院的对象
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMajor_name() {
		return major_name;
	}
	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}
	public String getMajor_sequence() {
		return major_sequence;
	}
	public void setMajor_sequence(String major_sequence) {
		this.major_sequence = major_sequence;
	}
	public String getMajor_type() {
		return major_type;
	}
	public void setMajor_type(String major_type) {
		this.major_type = major_type;
	}
	public String getMajor_semeters() {
		return major_semeters;
	}
	public void setMajor_semeters(String major_semeters) {
		this.major_semeters = major_semeters;
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
