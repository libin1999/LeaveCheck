package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.OptUrl;;

public interface OptUrlDao {
	//ͨ��id���Ҷ�Ӧ�����Ӷ���
	public OptUrl getOptUrlById(int id); 
	//ͨ��idֵɾ�����Ӷ���
	public int deleteById(int id);
	//��ȡ�������ӵ�ȫ����Ϣ
	public List<OptUrl> getOptUrllist();
	//z����������Ϣ
	public int addOptUrl(OptUrl opturl);
	//�޸�������Ϣ
	public int updateOptUrl(OptUrl opturl);
	//ͨ�����ڵ�id��ȡ�ӽڵ��id
	public List<OptUrl> getSubmMeanus(int parent);
}
