package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.MajorInfo;

public interface MajorInfoDao {
		//ͨ��id���Ҷ�Ӧ��רҵ����
		public MajorInfo getMajorById(int id); 
		//ͨ��idֵɾ��רҵ����
		public int deleteById(int id);
		//��ȡ����רҵ��ȫ����Ϣ
		public List<MajorInfo> getMajorlist();
		//z����רҵ��Ϣ
		public int addMajor(MajorInfo major);
		//�޸�רҵ��Ϣ
		public int updateMajor(MajorInfo major);
}
