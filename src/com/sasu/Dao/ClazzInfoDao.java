package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.ClazzInfo;

public interface ClazzInfoDao {
	//ͨ��id���Ҷ�Ӧ�İ༶����
	public ClazzInfo getClazzById(int id); 
	//ͨ��idֵɾ���༶����
	public int deleteById(int id);
	//��ȡ�༶��ȫ����Ϣ
	public List<ClazzInfo> getClazzlist();
	//z���Ӱ༶��Ϣ
	public int addClazz(ClazzInfo clazz);
	//�޸İ༶��Ϣ
	public int updateClazz(ClazzInfo clazz);
}
