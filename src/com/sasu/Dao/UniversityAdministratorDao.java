package com.sasu.Dao;


import java.util.List;

import com.sasu.entiy.UniversityAdministrator;

public interface UniversityAdministratorDao {
	//通过id查找对应的对象
	public UniversityAdministrator getUniAdminById(int id);
	//通过id值删除班级对象
	public int deleteById(int id);
	//增加
	public int addUniAdmin(UniversityAdministrator uniAdmin);
	//修改
	public int updateUniAdmin(UniversityAdministrator uniAdmin);
	public List<UniversityAdministrator> getUniversityAdministratorlist();
}
