package com.sasu.control;

import javax.servlet.http.HttpServletRequest;


import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sasu.entiy.StudentInfo;

@SuppressWarnings("serial")
public class StudnetAction extends ActionSupport implements ServletRequestAware{
	private HttpServletRequest request;
	private StudentInfo student;
	
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public StudentInfo getStudent() {
		return student;
	}
	public void setStudent(StudentInfo student) {
		this.student = student;
	}
	
	public String leaveday() {
		
		student=(StudentInfo)request.getSession().getAttribute("user");
		if(student!=null)
			return "success";
		else
			return "false";
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}
}
