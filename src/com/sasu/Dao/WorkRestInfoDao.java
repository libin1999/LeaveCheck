package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.WorkRestInfo;

public interface WorkRestInfoDao {
	public WorkRestInfo getWorkRestById(int id); 
	public int deleteById(int id);
	public int addWorkRest(WorkRestInfo workrest);
	public int updateWorkRest(WorkRestInfo workrest);
	public List<WorkRestInfo> getWorkRestInfolist();

}
