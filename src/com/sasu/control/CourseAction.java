package com.sasu.control;

import java.util.List;

import com.sasu.Dao.CourseInfoDao;
import com.sasu.DaoImpl.CourseInfoDaoImpl;
import com.sasu.entiy.CourseInfo;

public class CourseAction extends BaseAction {
	private List<CourseInfo> courses;
	private CourseInfo course;
	private int id;
	public List<CourseInfo> getCourses() {
		return courses;
	}
	public void setCourses(List<CourseInfo> courses) {
		this.courses = courses;
	}
	public CourseInfo getCourse() {
		return course;
	}
	public void setCourse(CourseInfo course) {
		this.course = course;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String list() {		
		CourseInfoDao courseInfoDao = new CourseInfoDaoImpl();
		this.courses = courseInfoDao.getCourselist();		
		return "list";		
	}
	
	public String update() {
		
		CourseInfoDao courseInfoDao = new CourseInfoDaoImpl();
		this.course =  courseInfoDao.getCourseById(this.id);
		courseInfoDao.updateCourse(this.course);
		
		return "update";
	}
	
	public String doUpdate() {
		 if(this.course.getCourse_name().equals("")) {
			System.out.println("ֵΪ��");
			request.setAttribute("err2", "������γ���");
			request.setAttribute("id", course.getId());
			return "fail-update";
			
		}else if(this.course.getCoursse_semester().equals("")) {
			System.out.println("ֵΪ��2");
			request.setAttribute("err3", "������γ̿���ѧ��");
			request.setAttribute("id", course.getId());
			return "fail-update";
			
		}else {
			System.out.println("����ִ�в���");
			CourseInfoDao courseInfoDao = new CourseInfoDaoImpl();
			int count=courseInfoDao.updateCourse(this.course);
			System.out.println(count);
			return "do-update";
		}
	}
	
	public String doDelete() {
		CourseInfoDao courseInfoDao = new CourseInfoDaoImpl();
		courseInfoDao.deleteById(this.id);
		return "do-delete";
	}
	
	public String add() {
		
		return "add";
	}
	
	public String doAdd() {
		Boolean flag = true;
		if(String.valueOf(this.course.getId()).equals("")) {
			flag = false;
			request.setAttribute("err1", "��������");
		}else if(this.course.getCourse_name().equals("")) {
			flag = false;
			request.setAttribute("err2", "������γ���");
		}else if(this.course.getCoursse_semester().equals("")) {
			flag = false;
			request.setAttribute("err3", "������γ̿���ѧ��");
		}if(flag) {
			CourseInfoDao courseInfoDao = new CourseInfoDaoImpl();
			courseInfoDao.addCourse(this.course);
			return "do-add";
		}
		return "fail-add";
	}
}
