package com.sasu.entiy;

public class CounselorInfo {	//年级辅导员信息		曾佳跃
	private int id;
	private String counselor_number; 	//辅导员教职工编号
	private String counselor_name;		//辅导员姓名
	private String counselor_sex;		//辅导员性别
	private int college_id;			//辅导员所在那个学院
	private CollegeInfo college;		//学院信息对象
	private String phone;
	private String gard;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGard() {
		return gard;
	}
	public void setGard(String gard) {
		this.gard = gard;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCounselor_number() {
		return counselor_number;
	}
	public void setCounselor_number(String counselor_number) {
		this.counselor_number = counselor_number;
	}
	public String getCounselor_name() {
		return counselor_name;
	}
	public void setCounselor_name(String counselor_name) {
		this.counselor_name = counselor_name;
	}
	public String getCounselor_sex() {
		return counselor_sex;
	}
	public void setCounselor_sex(String counselor_sex) {
		this.counselor_sex = counselor_sex;
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
