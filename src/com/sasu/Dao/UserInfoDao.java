package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.UserInfo;

public interface UserInfoDao {
	//通过id查找对应的用户对象
	public UserInfo getUserById(int id); 
	//通过id值删除用户对象
	public int deleteById(int id);
	//获取所有用户的全部信息
	public List<UserInfo> getUserlist();
	//z增加用户信息
	public int addMajor(UserInfo user);
	//修改用户信息
	public int updateMajor(UserInfo user);
	//通过账号查询
	public UserInfo getUserByNumber(String number) ;
}
