package com.sasu.entiy;

public class UserInfo {			//用户账号数据表		李斌
	private int id;
	private String username;
	private String password;
	private int role;
	private RoleInfo roleinfo;
	
	public RoleInfo getRoleinfo() {
		return roleinfo;
	}
	public void setRoleinfo(RoleInfo roleinfo) {
		this.roleinfo = roleinfo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
}
