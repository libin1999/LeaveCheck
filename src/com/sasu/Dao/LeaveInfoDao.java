package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.LeaveInfo;



public interface LeaveInfoDao {
	//ͨ��id���Ҷ�Ӧ�Ľ�ʦ����
	public LeaveInfo getLeaveById(int id);
	//ͨ��idֵɾ����ʦ����
	public int deleteById(int id);
	//��ȡ��ʦ��ȫ����Ϣ
	public List<LeaveInfo> getLeavelist();
	//���ӽ�ʦ��Ϣ
	public int addLeave(LeaveInfo leave);
	//�޸Ľ�ʦ��Ϣ
	public int updateLeaveById(LeaveInfo leave);

}
