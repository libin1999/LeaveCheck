package com.sasu.Util;

import java.io.File;
import java.util.List;

import com.sasu.Dao.LeaveInfoDao;
import com.sasu.DaoImpl.LeaveInfoDaoImpl;
import com.sasu.entiy.LeaveInfo;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelUtil {
	public static int setExcel(String path) {
		int count=1;
		try  {
		       // ���ļ� 
		       WritableWorkbook book = Workbook.createWorkbook( new File(path));
		       // ������Ϊ����һҳ���Ĺ���������0��ʾ���ǵ�һҳ 
		       WritableSheet sheet = book.createSheet( " ��һҳ " , 0 );
		       //��������һ���ı���
		       sheet.addCell(new Label(0 , 0, "ѧ��"));
		       sheet.addCell(new Label(1 , 0, "����"));
		       sheet.addCell(new Label(2 , 0, "�༶"));
		       sheet.addCell(new Label(3 , 0, "ѧ���绰"));
		       sheet.addCell(new Label(4 , 0, "�໤��"));
		       sheet.addCell(new Label(5 , 0, "�໤�˵绰"));
		       sheet.addCell(new Label(6 , 0, "���ʱ��"));
		       sheet.addCell(new Label(7 , 0, "���ԭ��"));
		       sheet.addCell(new Label(8 , 0, "����ʱ��"));
		       sheet.addCell(new Label(9,0,"����ʱ��"));
		       //��ȡ��ٱ��е�ȫ������
		       LeaveInfoDao dao=new LeaveInfoDaoImpl();
				List<LeaveInfo> list=dao.getLeavelist();
				//���������е�������Ϣ
				for(LeaveInfo info:list) {
						// ��Label����Ĺ�������ָ����Ԫ��λ���������
				       // ������õĵ�Ԫ����ӵ��������� 
				       sheet.addCell(new Label(0 , count, info.getStudent().getStu_number() ));
				       sheet.addCell(new Label(1 , count, info.getStudent().getStu_name()));
				       sheet.addCell(new Label(2 , count ,info.getStudent().getClazz().getClazz_name()));
				       sheet.addCell(new Label(3 , count ,info.getStudent().getStu_phone()));
				       sheet.addCell(new Label(4 , count ,info.getStudent().getStu_parent()));
				       sheet.addCell(new Label(5 , count ,info.getStudent().getStu_parentPhone()));
				       sheet.addCell(new Label(6 , count ,info.getLeave_begin()));
				       sheet.addCell(new Label(7 , count ,info.getLeave_reason()));
				       sheet.addCell(new Label(8 , count ,info.getLeave_end()));
				       count++;
				}
		       
		       /* 
		       * ����һ���������ֵĵ�Ԫ�� ����ʹ��Number��������·�����������﷨���� ��Ԫ��λ���ǵڶ��У���һ�У�ֵΪ789.123
//		       */
//		      jxl.write.Number number =  new jxl.write.Number(1 , 0 , 9999999);
//		      sheet.addCell(number);
		       // д�����ݲ��ر��ļ� 
		      book.write();
		      book.close();
		 
		    }  catch (Exception e) {
		      System.out.println(e);
		    }
		return count; 
		
	}
}
