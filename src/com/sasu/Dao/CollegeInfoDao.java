package com.sasu.Dao;

import java.util.List;

import com.sasu.entiy.CollegeInfo;;

public interface CollegeInfoDao {
		//ͨ��id���Ҷ�Ӧ��ѧԺ����
		public CollegeInfo getCollegeById(int id); 
		//ͨ��idֵɾ��ѧԺ����
		public int deleteById(int id);
		//��ȡ���е�ȫ����Ϣ
		public List<CollegeInfo> getCollegelist();
		//z����ѧԺ��Ϣ
		public int addCollege(CollegeInfo college);
		//�޸�ѧԺ��Ϣ
		public int updateCollege(CollegeInfo college);
}
