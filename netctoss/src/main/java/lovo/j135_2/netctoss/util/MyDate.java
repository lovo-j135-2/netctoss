package lovo.j135_2.netctoss.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 该类负责获取当前日期，并将此日期返回为sql 的日期
 * @author Johney
 *
 */
public class MyDate {
	/**
	 * 获取当前日期方法
	 * @return 返回sql的时间对象
	 */
	public static java.sql.Date getDate(){
		java.util.Date dateUtil=new java.util.Date();
		java.sql.Date dateSQL=new java.sql.Date(dateUtil.getTime());
		return dateSQL;
	}
	public static java.util.Date getDate(java.sql.Date date){
		java.util.Date dateUtil=new java.util.Date(date.getTime());
		return dateUtil;
	}

	public static java.sql.Date getDate(java.util.Date date){
		java.sql.Date dateSQL=new java.sql.Date(date.getTime());
		return dateSQL;
	}
	public static java.sql.Date stringToDate(String string){
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date dateSQL=null;
		try {
			java.util.Date dateUtil = simple.parse(string);
			dateSQL=new java.sql.Date(dateUtil.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		return dateSQL;
	}
	
	public static String dateToString(java.util.Date date){
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String string=simple.format(date);
		return string;
	}
	
	public static java.util.Date stringToUtilDate(String string){
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		java.util.Date date=null;
		try {
			date = simple.parse(string);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	public static void main(String[] args) {
		Date date=new Date();
	}
}
