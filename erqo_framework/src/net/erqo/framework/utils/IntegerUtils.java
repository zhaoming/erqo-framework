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
public class IntegerUtils {
	/**
	 * 转换整型
	 * 
	 * @param string
	 * @return
	 */
	public static Integer parseInt(String string) {
		try {
			return Integer.valueOf(string);
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
