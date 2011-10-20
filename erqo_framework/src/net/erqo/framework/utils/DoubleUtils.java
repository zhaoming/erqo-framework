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
public class DoubleUtils {
	/**
	 * 转换double型
	 * 
	 * @param string
	 * @return
	 */
	public static Double parseDouble(String string) {
		try {
			return Double.valueOf(string);
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
