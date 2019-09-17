package com.sasu.Util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MethodUtil {
	public static float getTimeAmount(String startTime,String endTime) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startDate=new Date();
		Date endDate=new Date();
		try {
			startDate=sdf.parse(startTime);
			endDate=sdf.parse(endTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		float amount=(float) ((endDate.getTime()-startDate.getTime())/(float)(1000*60*60*24));
		DecimalFormat fnum = new DecimalFormat("##0.0");
		float dd=Float.parseFloat( fnum.format(amount));
		return dd;
	}
}
