package test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;

import com.sasu.Dao.StudentInfoDao;
import com.sasu.DaoImpl.StudentInfoDaoImpl;
import com.sasu.Util.MethodUtil;
import com.sasu.control.StudnetAction;
import com.sasu.entiy.StudentInfo;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		CollegeInfoDao dao=new CollegeInfoDaoImpl();
//		CollegeInfo college=new CollegeInfo();
//		college.setId(1);
//		college.setName("智能制造学院");
//		college.setSequence(2);
//		dao.updateCollege(college);
		
//		String phone="18908240242";
//		String content="有会议室预约，需要审核请赶快登录系统";
//		int id=334910;
//		SendMessage.setmessage(id, phone, content);
		
//		float amount=MethodUtil.getTimeAmount("2019-09-10 08:00:00", "2019-09-11 08:00:00");
//		System.out.println(amount); 
		
		int i;
        Sheet sheet;
        Workbook book;
        Cell cell1,cell2,cell3,cell4,cell5,cell6,cell7;
        try { 
        	 InputStream is = new FileInputStream("C://Users/ASUS/Desktop/MyFristHibernate/test.xls");
            //test.xls为要读取的excel文件名
            book= Workbook.getWorkbook(is); 
            //获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
            sheet=book.getSheet(0); 
            
            i=0;
            while(true)
            {
            	StudentInfo info=new StudentInfo();
                //获取每一行的单元格 
            	if(i==sheet.getRows())
            		break;
            	
                cell1=sheet.getCell(0,i);//（列，行）
                info.setStu_number(cell1+"");
                cell2=sheet.getCell(1,i);
                cell3=sheet.getCell(2,i);
                System.out.println(cell1.getContents()+"\t"+cell2.getContents()+"\t"+cell3.getContents()); 
                
                StudentInfoDao dao=new StudentInfoDaoImpl();
                dao.addStudent(info);
                i++;
            }
            book.close(); 
        }
        catch(Exception e)  {
        	e.printStackTrace();
        }
	}

}
