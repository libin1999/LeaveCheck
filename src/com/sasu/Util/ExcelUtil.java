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
		       // 打开文件 
		       WritableWorkbook book = Workbook.createWorkbook( new File(path));
		       // 生成名为“第一页”的工作表，参数0表示这是第一页 
		       WritableSheet sheet = book.createSheet( " 第一页 " , 0 );
		       //制作表格第一栏的标题
		       sheet.addCell(new Label(0 , 0, "学号"));
		       sheet.addCell(new Label(1 , 0, "姓名"));
		       sheet.addCell(new Label(2 , 0, "班级"));
		       sheet.addCell(new Label(3 , 0, "学生电话"));
		       sheet.addCell(new Label(4 , 0, "监护人"));
		       sheet.addCell(new Label(5 , 0, "监护人电话"));
		       sheet.addCell(new Label(6 , 0, "请假时间"));
		       sheet.addCell(new Label(7 , 0, "请假原因"));
		       sheet.addCell(new Label(8 , 0, "结束时间"));
		       sheet.addCell(new Label(9,0,"销假时间"));
		       //获取请假表中的全部数据
		       LeaveInfoDao dao=new LeaveInfoDaoImpl();
				List<LeaveInfo> list=dao.getLeavelist();
				//遍历集合中的所有信息
				for(LeaveInfo info:list) {
						// 在Label对象的构造子中指名单元格位置添加数据
				       // 将定义好的单元格添加到工作表中 
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
		       * 生成一个保存数字的单元格 必须使用Number的完整包路径，否则有语法歧义 单元格位置是第二列，第一行，值为789.123
//		       */
//		      jxl.write.Number number =  new jxl.write.Number(1 , 0 , 9999999);
//		      sheet.addCell(number);
		       // 写入数据并关闭文件 
		      book.write();
		      book.close();
		 
		    }  catch (Exception e) {
		      System.out.println(e);
		    }
		return count; 
		
	}
}
