package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.RoleUrlInfo;

public interface RoleUrlInfoDao {
	
	public RoleUrlInfo getRoleUrlInfoById(int id); 
	
	public int deleteById(int id);
	
	public List<RoleUrlInfo> getRoleUrlInfolist();
	
	public int addRoleUrlInfo(RoleUrlInfo role);
	
	public int updateRoleUrlInfo(RoleUrlInfo role);
}
