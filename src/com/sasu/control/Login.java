package com.sasu.control;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sasu.Dao.StudentInfoDao;
import com.sasu.Dao.UserInfoDao;
import com.sasu.DaoImpl.StudentInfoDaoImpl;
import com.sasu.DaoImpl.UserInfoDaoImpl;
import com.sasu.entiy.StudentInfo;
import com.sasu.entiy.UserInfo;


public class Login extends ActionSupport implements ServletRequestAware{
	
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private UserInfo user;
	
	
	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	//��¼��֤
	public String login() {
		System.out.println(request.getSession().getServletContext().getRealPath("/"));
		UserInfoDao dao=new UserInfoDaoImpl();
		UserInfo info=dao.getUserByNumber(user.getUsername());
		if(info==null) {
			request.setAttribute("username", "�˻�������");
			return "false";
		}else {
			if(info.getPassword().equals(user.getPassword())) {	//�����������ݿ��е���ȣ����жϽ�ɫֵ��
				
				if(info.getRole()==1) {	//���Ϊ1����ת��ѧ�����ܽ���
					StudentInfoDao infodao=new StudentInfoDaoImpl();
					StudentInfo studentinfo=infodao.getStudentByNumber(info.getId());
					request.getSession().setAttribute("user", studentinfo);
					return "student";
				}else {
					return "success";
				}
			}else {
				request.setAttribute("password", "�������");
				return "false";
			}
		}
	}
	//�˳�
	public String exit() {
		request.getSession().invalidate();
		return "success";
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}
	
}
