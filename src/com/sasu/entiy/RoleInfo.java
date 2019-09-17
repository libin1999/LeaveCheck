package com.sasu.entiy;

import java.util.List;

public class RoleInfo {				//角色信息		李斌
	private int id;
	private String role_name;
	private String role_info;
	private List<RoleUrlInfo> list;
	public List<RoleUrlInfo> getList() {
		return list;
	}
	public void setList(List<RoleUrlInfo> list) {
		this.list = list;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_info() {
		return role_info;
	}
	public void setRole_info(String role_info) {
		this.role_info = role_info;
	}
}
