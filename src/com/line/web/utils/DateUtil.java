package com.line.web.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	private static Calendar cal = Calendar.getInstance();
	
	public static String getFormatDate(){
		return format.format(new Date());
	}
	
	public static long getCurTimeMills(){
		return System.currentTimeMillis();
	}
	
	public static void main(String[] args){
		System.out.println(getCurTimeMills());
	}
}
