package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.CounselorInfo;

public interface CounselorInfoDao {
	public CounselorInfo getCounselorById(int id);
	//ͨ��id�����꼶����Ա����
	public int deleteById(int id);
	//ͨ��idֵɾ���꼶����Ա����
	public List<CounselorInfo> getCounselorList();
	//��ȡȫ����Ϣ
	public int addCounselor(CounselorInfo counselor);
	//����꼶����Ա��Ϣ
	public int updateCounselor(CounselorInfo counselor);
	//�޸��꼶����Ա��Ϣ

}
