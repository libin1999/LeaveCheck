package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.ParentReply;

public interface ParentReplyDao {
	public ParentReply getParentReplyById(int id); 
	public int deleteById(int id);
	public int addParentReply(ParentReply parReply);
	public int updateParentReply(ParentReply parReply);
	public List<ParentReply> getParentReplylist();
}
