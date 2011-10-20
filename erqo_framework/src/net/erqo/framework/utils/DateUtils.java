package net.erqo.framework.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils extends org.apache.commons.lang.time.DateUtils {
	public static String DF_YYYYMMDD = "yyyy-MM-dd";
	public static String DF_YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";
	public static String DF_YYYYMMDDHHMMSSS = "yyyy-MM-dd HH:mm:sss";

	public static java.util.Date parseDate(java.lang.String str,
			java.lang.String[] parsePatterns) throws java.text.ParseException {
		return org.apache.commons.lang.time.DateUtils.parseDate(str,
				parsePatterns);
	}

	public static java.util.Date parseDate(java.lang.String str) {
		Date date = null;
		if(!StringUtils.isEmpty(str)){
			try {
				date = DateUtils.parseDate(str, new String[] { DF_YYYYMMDD });
			} catch (ParseException pe) {
				pe.printStackTrace();
			}
		}
		return date;
	}

	public static String formatDate(Date date, String pattern) {
		if(null!=date){
			DateFormat df = new SimpleDateFormat(pattern);
			return df.format(date);
		}else{
			return "";
		}
	}

	/**
	 * 获取生日,输入的字符串按照yyyy-MM-dd进行parse并转换成为时
	 * 
	 * @param str
	 *            传入参数
	 * @return 返回结果
	 */
	public static Date getBirthDay(String str) {
		Date date = null;
		try {
			date = DateUtils.parseDate(str, new String[] { DF_YYYYMMDD });
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		return date;
	}
}
