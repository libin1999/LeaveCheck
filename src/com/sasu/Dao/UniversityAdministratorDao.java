package com.sasu.Dao;


import java.util.List;

import com.sasu.entiy.UniversityAdministrator;

public interface UniversityAdministratorDao {
	//ͨ��id���Ҷ�Ӧ�Ķ���
	public UniversityAdministrator getUniAdminById(int id);
	//ͨ��idֵɾ���༶����
	public int deleteById(int id);
	//����
	public int addUniAdmin(UniversityAdministrator uniAdmin);
	//�޸�
	public int updateUniAdmin(UniversityAdministrator uniAdmin);
	public List<UniversityAdministrator> getUniversityAdministratorlist();
}
