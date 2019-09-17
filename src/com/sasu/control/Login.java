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

	//登录验证
	public String login() {
		System.out.println(request.getSession().getServletContext().getRealPath("/"));
		UserInfoDao dao=new UserInfoDaoImpl();
		UserInfo info=dao.getUserByNumber(user.getUsername());
		if(info==null) {
			request.setAttribute("username", "账户不存在");
			return "false";
		}else {
			if(info.getPassword().equals(user.getPassword())) {	//如果密码和数据库中的相等，则判断角色值。
				
				if(info.getRole()==1) {	//如果为1，跳转至学生功能界面
					StudentInfoDao infodao=new StudentInfoDaoImpl();
					StudentInfo studentinfo=infodao.getStudentByNumber(info.getId());
					request.getSession().setAttribute("user", studentinfo);
					return "student";
				}else {
					return "success";
				}
			}else {
				request.setAttribute("password", "密码错误");
				return "false";
			}
		}
	}
	//退出
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
