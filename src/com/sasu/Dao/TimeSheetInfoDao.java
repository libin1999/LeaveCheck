package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.TimeSheet;



public interface TimeSheetInfoDao {
	//ͨ��id���Ҷ�Ӧ�Ŀ��ڱ�
	public TimeSheet getTimeSheetById(int id);
	//ͨ��idֵɾ�����ڱ�
	public int deleteById(int id);
	//��ȡ���ڱ��ȫ����Ϣ
	public List<TimeSheet> getTimelist();
	//���ӿ��ڱ����Ϣ
	public int addTimeSheet(TimeSheet time);
	//�޸Ŀ��ڱ���Ϣ
	public int updateTimeSheetById(TimeSheet time);
	
	

}
