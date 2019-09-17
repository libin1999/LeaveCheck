package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.OptUrl;;

public interface OptUrlDao {
	//通过id查找对应的链接对象
	public OptUrl getOptUrlById(int id); 
	//通过id值删除链接对象
	public int deleteById(int id);
	//获取所有链接的全部信息
	public List<OptUrl> getOptUrllist();
	//z增加链接信息
	public int addOptUrl(OptUrl opturl);
	//修改链接信息
	public int updateOptUrl(OptUrl opturl);
	//通过父节点id获取子节点的id
	public List<OptUrl> getSubmMeanus(int parent);
}
