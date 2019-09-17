package com.sasu.control;

import java.util.List;

import com.sasu.Dao.LessonInfoDao;
import com.sasu.DaoImpl.LessonInfoDaoImpl;
import com.sasu.entiy.LessonInfo;

public class LessonAction extends BaseAction {
	private List<LessonInfo> lessons;
	private LessonInfo lesson;
	private int id;
	public List<LessonInfo> getLessons() {
		return lessons;
	}
	public void setLessons(List<LessonInfo> lessons) {
		this.lessons = lessons;
	}
	public LessonInfo getLesson() {
		return lesson;
	}
	public void setLesson(LessonInfo lesson) {
		this.lesson = lesson;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String list() {
		LessonInfoDao lessonInfoDao = new LessonInfoDaoImpl();
		this.lessons = lessonInfoDao.getLessonlist();
		return "list";
	}
	
	public String update() {
		LessonInfoDao lessonInfoDao = new LessonInfoDaoImpl();
		this.lesson = lessonInfoDao.getLessonById(this.id);
		lessonInfoDao.updateLesson(this.lesson);
		return "update";
	}
	
	public String doUpdate() {
		Boolean flag = true;
		if(String.valueOf(this.lesson.getId()).equals("")) {
			flag = false;
			request.setAttribute("err1", "��������");
		}else if(String.valueOf(this.lesson.getCourse_id()).equals("")) {
			flag = false;
			request.setAttribute("err2", "������γ̱��");
		}else if(String.valueOf(this.lesson.getClazz_id()).equals("")) {
			flag = false;
			request.setAttribute("err3", "�������Ͽΰ༶���");
		}else if(this.lesson.getClazz_room().equals("")) {
			flag = false;
			request.setAttribute("err3", "�������Ͽν���");
		}else if(String.valueOf(this.lesson.getTeacher_id()).equals("")) {
			flag = false;
			request.setAttribute("err3", "�������Ͽν�ʦ���");
		}else if(String.valueOf(this.lesson.getWeekday()).equals("")) {
			flag = false;
			request.setAttribute("err3", "�������Ͽ�ʱ��");
		}else if(String.valueOf(this.lesson.getClazz_begin()).equals("")) {
			flag = false;
			request.setAttribute("err3", "�������Ͽγ̿�ʼʱ��");
		}else if(String.valueOf(this.lesson.getClazz_over()).equals("")) {
			flag = false;
			request.setAttribute("err3", "������γ̽���ʱ��");
		}
		if(flag) {
			LessonInfoDao lessonInfoDao = new LessonInfoDaoImpl();
			lessonInfoDao.updateLesson(this.lesson);
			return "do-update";
		}
		return "fail-update";
	}
	
	public String doDelete() {
		LessonInfoDao lessonInfoDao = new LessonInfoDaoImpl();
		lessonInfoDao.deleteById(this.id);
		return "do-delete";
	}
	
	public String add() {
		
		return "add";
	}
	
	public String doAdd() {
		Boolean flag = true;
		if(String.valueOf(this.lesson.getCourse_id()).equals("")) {
			flag = false;
			request.setAttribute("err2", "������γ̱��");
		}else if(String.valueOf(this.lesson.getClazz_id()).equals("")) {
			flag = false;
			request.setAttribute("err3", "�������Ͽΰ༶���");
		}else if(this.lesson.getClazz_room().equals("")) {
			flag = false;
			request.setAttribute("err3", "�������Ͽν���");
		}else if(String.valueOf(this.lesson.getTeacher_id()).equals("")) {
			flag = false;
			request.setAttribute("err3", "�������Ͽν�ʦ���");
		}else if(String.valueOf(this.lesson.getWeekday()).equals("")) {
			flag = false;
			request.setAttribute("err3", "�������Ͽ�ʱ��");
		}else if(String.valueOf(this.lesson.getClazz_begin()).equals("")) {
			flag = false;
			request.setAttribute("err3", "�������Ͽγ̿�ʼʱ��");
		}else if(String.valueOf(this.lesson.getClazz_over()).equals("")) {
			flag = false;
			request.setAttribute("err3", "������γ̽���ʱ��");
		}
		if(flag) {
			LessonInfoDao lessonInfoDao = new LessonInfoDaoImpl();
			lessonInfoDao.addLesson(this.lesson);
			return "do-add";
		}
		return "fail-add";
	}
}
