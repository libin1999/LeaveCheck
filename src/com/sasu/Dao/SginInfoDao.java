package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.SginInfo;

public interface SginInfoDao {
	public SginInfo getSginInfoById(int id);
	//ͨ��id���Ҷ�Ӧ�İ�������˶���	
	public int deleteById(int id);
	//ͨ��idֵɾ����������˶���
	public List<SginInfo> getSginInfoList();
	//��ȡȫ����Ϣ
	public int addSginInfo(SginInfo sgin);
	//��Ӱ����������Ϣ	
	public int updateSginInfo(SginInfo sgin);
	//�޸İ����������Ϣ	

}
