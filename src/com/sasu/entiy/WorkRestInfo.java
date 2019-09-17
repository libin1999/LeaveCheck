package com.sasu.entiy;

public class WorkRestInfo {		//学校作息时间表		谭力
	private int id;
	private String sequence;	//第几节时间
	private String time_begin;	//开始时间
	private String time_end;	//结束时间
	private String semester;	//第几学期作息时间表
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public String getTime_begin() {
		return time_begin;
	}
	public void setTime_begin(String time_begin) {
		this.time_begin = time_begin;
	}
	public String getTime_end() {
		return time_end;
	}
	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	

}
