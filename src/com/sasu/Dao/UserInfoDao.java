package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.UserInfo;

public interface UserInfoDao {
	//ͨ��id���Ҷ�Ӧ���û�����
	public UserInfo getUserById(int id); 
	//ͨ��idֵɾ���û�����
	public int deleteById(int id);
	//��ȡ�����û���ȫ����Ϣ
	public List<UserInfo> getUserlist();
	//z�����û���Ϣ
	public int addMajor(UserInfo user);
	//�޸��û���Ϣ
	public int updateMajor(UserInfo user);
	//ͨ���˺Ų�ѯ
	public UserInfo getUserByNumber(String number) ;
}
