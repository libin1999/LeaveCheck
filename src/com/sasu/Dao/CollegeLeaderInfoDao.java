package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.CollegeLeaderInfo;

public interface CollegeLeaderInfoDao {

	public CollegeLeaderInfo getCollegeLeaderInfoById(int id);
	//ͨ��id���Ҷ�ӦѧԺ�쵼����
	public int deleteById(int id);
	//ͨ��id��ֵɾ��ѧԺ�쵼����
	public List<CollegeLeaderInfo> getCollegeLeaderlist();
	//��ȡȫ����Ϣ
	public int addCollegeLeader(CollegeLeaderInfo collegeLeader);
	//���ѧԺ�쵼��Ϣ
	public int updateCollegeLeader(CollegeLeaderInfo collegeLeader);
	//�޸�ѧԺ�쵼��Ϣ
	
}
