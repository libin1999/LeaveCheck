package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.RoleInfo;

public interface RoleInfoDao {
		//ͨ��id���Ҷ�Ӧ�Ľ�ɫ����
		public RoleInfo getRoleInfoById(int id); 
		//ͨ��idֵɾ����ɫ����
		public int deleteById(int id);
		//��ȡ���н�ɫ��ȫ����Ϣ
		public List<RoleInfo> getRoleInfolist();
		//���ӽ�ɫ��Ϣ
		public int addRoleInfo(RoleInfo role);
		//�޸Ľ�ɫ��Ϣ
		public int updateRoleInfo(RoleInfo role);
}
