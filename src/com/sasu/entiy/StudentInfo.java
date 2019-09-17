package com.sasu.entiy;

public class StudentInfo {		//学生信息		罗胜
	private int id;
	private String stu_number;	//学号
	private UserInfo user;		//学生的账户密码对象
	private String stu_name;	//姓名
	private String stu_sex;		//性别
	private String stu_phone; 	//学生的联系方式
	private int stu_grade;		//入学年份
	private	String stu_photofile;   //学生照片文件名信息
	private String stu_parent;		//学生父母姓名
	private String stu_parentPhone;	//学生父母联系方式
	private String stu_home_adrress;	//学生家庭住址
	private int clazz_id;		//学生所在班级的编号
	private ClazzInfo clazz;	//学生所在班级对象的信息
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStu_number() {
		return stu_number;
	}
	public void setStu_number(String stu_number) {
		this.stu_number = stu_number;
	}
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_sex() {
		return stu_sex;
	}
	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}
	public String getStu_phone() {
		return stu_phone;
	}
	public void setStu_phone(String stu_phone) {
		this.stu_phone = stu_phone;
	}
	public int getStu_grade() {
		return stu_grade;
	}
	public void setStu_grade(int stu_grade) {
		this.stu_grade = stu_grade;
	}
	public String getStu_photofile() {
		return stu_photofile;
	}
	public void setStu_photofile(String stu_photofile) {
		this.stu_photofile = stu_photofile;
	}
	public String getStu_parent() {
		return stu_parent;
	}
	public void setStu_parent(String stu_parent) {
		this.stu_parent = stu_parent;
	}
	public String getStu_parentPhone() {
		return stu_parentPhone;
	}
	public void setStu_parentPhone(String stu_parentPhone) {
		this.stu_parentPhone = stu_parentPhone;
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
	public String getStu_home_adrress() {
		return stu_home_adrress;
	}
	public void setStu_home_adrress(String stu_home_adrress) {
		this.stu_home_adrress = stu_home_adrress;
	}
	
	

}
