package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.RoleInfo;

public interface RoleInfoDao {
		//通过id查找对应的角色对象
		public RoleInfo getRoleInfoById(int id); 
		//通过id值删除角色对象
		public int deleteById(int id);
		//获取所有角色的全部信息
		public List<RoleInfo> getRoleInfolist();
		//增加角色信息
		public int addRoleInfo(RoleInfo role);
		//修改角色信息
		public int updateRoleInfo(RoleInfo role);
}
