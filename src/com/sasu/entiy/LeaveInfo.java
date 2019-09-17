package com.sasu.entiy;

public class LeaveInfo {		//请假信息		罗胜
	private int id;
	private int student_id;		//该学生对应的id值
	private StudentInfo student;	//该学生对象
	private String record_item;	//请假方式（事假，病假）
	private String leave_reason;	//请假原因
	private String leave_begin;		//请假开始时间
	private String leave_end;		//请假截止时间
	private int record_status;		//请假状况(1,2,3)
	private String record_date;		//创建记录时间
	
	public StudentInfo getStudent() {
		return student;
	}
	public void setStudent(StudentInfo student) {
		this.student = student;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	
	public String getRecord_item() {
		return record_item;
	}
	public void setRecord_item(String record_item) {
		this.record_item = record_item;
	}
	public String getLeave_reason() {
		return leave_reason;
	}
	public void setLeave_reason(String leave_reason) {
		this.leave_reason = leave_reason;
	}
	public String getLeave_begin() {
		return leave_begin;
	}
	public void setLeave_begin(String leave_begin) {
		this.leave_begin = leave_begin;
	}
	public String getLeave_end() {
		return leave_end;
	}
	public void setLeave_end(String leave_end) {
		this.leave_end = leave_end;
	}
	public int getRecord_status() {
		return record_status;
	}
	public void setRecord_status(int record_status) {
		this.record_status = record_status;
	}
	public String getRecord_date() {
		return record_date;
	}
	public void setRecord_date(String record_date) {
		this.record_date = record_date;
	}
	

}
