package com.sasu.control;

import java.util.List;


import com.sasu.Dao.CollegeInfoDao;
import com.sasu.DaoImpl.CollegeInfoDaoImpl;
import com.sasu.entiy.CollegeInfo;

public class CollegeAction extends BaseAction {
	private List<CollegeInfo> colleges ;
	private CollegeInfo college;
	private int id;
	public List<CollegeInfo> getColleges() {
		return colleges;
	}
	public void setColleges(List<CollegeInfo> colleges) {
		this.colleges = colleges;
	}
	public CollegeInfo getCollege() {
		return college;
	}
	public void setCollege(CollegeInfo college) {
		this.college = college;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String list() {
		CollegeInfoDao collegeInfoDao = new CollegeInfoDaoImpl();
		this.colleges = collegeInfoDao.getCollegelist();
		return "list";
	}
	
	public String update() {
		
		CollegeInfoDao collegeInfoDao = new CollegeInfoDaoImpl();
		this.college =  collegeInfoDao.getCollegeById(this.id);
		collegeInfoDao.updateCollege(this.college);
		return "update";
	}
	
	public String doUpdate() {
		
		System.out.println(college.getId()+college.getName()+college.getSequence());
		Boolean flag = true;
		if(String.valueOf(this.college.getId()).equals("")) {
			flag = false;
			request.setAttribute("err1", "请输入编号");
		}else if(this.college.getName().equals("")) {
			flag = false;
			request.setAttribute("err2", "请输入学院名");
		}else if(String.valueOf(this.college.getSequence()).equals("")) {
			flag = false;
			request.setAttribute("err3", "请输入学院排序值");
		}
		if(flag) {
			CollegeInfoDao collegeInfoDao = new CollegeInfoDaoImpl();
			int result=collegeInfoDao.updateCollege(college);
			System.out.println(result);
			return "do-update";
		}
		return "fail-update";
	}
	
	public String doDelete() {
		CollegeInfoDao collegeInfoDao = new CollegeInfoDaoImpl();
		collegeInfoDao.deleteById(this.id);
		return "do-delete";
	}
	
	public String add() {

		return "add";
	}
	
	public String doAdd() {
		Boolean flag = true;
		if(String.valueOf(this.college.getId()).equals("")) {
			flag = false;
			request.setAttribute("err1", "请输入编号");
		}else if(this.college.getName().equals("")) {
			flag = false;
			request.setAttribute("err2", "请输入学院名");
		}else if(String.valueOf(this.college.getSequence()).equals("")) {
			flag = false;
			request.setAttribute("err3", "请输入学院排序值");
		}
		if(flag) {
			CollegeInfoDao collegeInfoDao = new CollegeInfoDaoImpl();
			collegeInfoDao.addCollege(this.college);
			return "do-add";
	}
	return "fail-add";
}
}
