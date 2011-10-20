package net.erqo.framework.utils;

/**
 * 
 * 标题：ERQO.NET
 * 
 * 作者：TONY 2009 1 21
 * 
 * 描述：
 * 
 * 说明:
 */
public class LongUtils {
	/**
	 * 转换Long型
	 * 
	 * @param string
	 * @return
	 */
	public static Long parseLong(String string) {
		try {
			return Long.valueOf(string);
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
