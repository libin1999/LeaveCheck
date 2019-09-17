package com.sasu.entiy;

public class UniversityAdministrator {		//学校学生管理部门信息		谭力
	private int id;
	private String admin_account;	//部门管理人员账户
	private String admin_name;	//部门管理人员姓名
	private String admin_sex;	//部门管理人员性别
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdmin_account() {
		return admin_account;
	}
	public void setAdmin_account(String admin_account) {
		this.admin_account = admin_account;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_sex() {
		return admin_sex;
	}
	public void setAdmin_sex(String admin_sex) {
		this.admin_sex = admin_sex;
	}
	

}
