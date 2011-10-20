package net.erqo.framework.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

public class StringUtils extends org.apache.commons.lang.StringUtils {

	private static final String ENCODING_DEFAULT = "UTF-8";
	private static final boolean NOCACHE_DEFAULT = true;
	
	/**
	 * 根据输入的时间格式判断是否是日期类型的字符串
	 * 
	 * @param str
	 *             要判断的字符 
	 * @param format
	 *            判断是否匹配对应的格 
	 * @return 返回匹配结果
	 */
	public static boolean isDate(String str, String format) {
		if (StringUtils.isEmpty(str))
			return false;
		if (StringUtils.isEmpty(format))
			return false;
		try {
			DateFormat df = new SimpleDateFormat(format);
			df.parse(str);
		} catch (Exception ex) {
			return false;
		}

		return true;
	}

	/**
	 * 将字符串str按reg的规则分解
	 * 
	 * @param str
	 * @param reg
	 *            如 '|'与':'等
	 * @return
	 */
	public static ArrayList<String> stringToArrayList(String str, String reg) {

		ArrayList<String> tmp = new ArrayList<String>();
		if (str == null)
			return tmp;
		String[] strArr = StringUtils.split(str, reg);
		if (str.length() > 0) {
			for (int i = 0; i < strArr.length; ++i) {

				tmp.add(strArr[i].toLowerCase());
			}
		}
		return tmp;
	}

	public static String toUnicode(String strText, String code)
			throws UnsupportedEncodingException {
		char c;
		String strRet = "";
		int intAsc;
		String strHex;
		// strText = new String(strText.getBytes("iso8859_1"), code);
		for (int i = 0; i < strText.length(); i++) {
			c = strText.charAt(i);
			intAsc = (int) c;
			if (intAsc > 128) {
				strHex = Integer.toHexString(intAsc);
				strRet = strRet + "&#x" + strHex + ";";
			} else {
				strRet = strRet + c;
			}
		}
		return strRet;
	}




	public static boolean checkNull(String str) {
		if (str == null || "".equals(str)) {
			return true;
		}
		return false;
	}

	private static void render(final HttpServletResponse response,
			final String contentType, final String content) {
		try {
			String encoding = ENCODING_DEFAULT;
			boolean noCache = NOCACHE_DEFAULT;

			String fullContentType = contentType + ";charset=" + encoding;
			response.setContentType(fullContentType);
			if (noCache) {
				response.setHeader("Pragma", "No-cache");
				response.setHeader("Cache-Control", "no-cache");
				response.setDateHeader("Expires", 0);
			}

			response.getWriter().write(content);
			response.getWriter().flush();

		} catch (IOException e) {
			throw new RuntimeException("");
		}
	}

	public static void renderText(final HttpServletResponse response,
			final String text) {
		render(response, "text/plain", text);
	}

	public static void renderXml(final HttpServletResponse response,
			final String text) {
		render(response, "text/xml", text);
	}	
	

	/**
	 * 生成随机字符串
	 * 
	 * @param length
	 * @return String
	 */
	public static String randomStr(int length) {
		// 数字 大小写字母
		StringBuffer buffer = new StringBuffer(
				"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		StringBuffer str = new StringBuffer();
		Random r = new Random();
		int range = buffer.length();
		for (int i = 0; i < length; i++) {
			str.append(buffer.charAt(r.nextInt(range)));
		}
		return str.toString();
	}
	/**
	 * 截取字符串
	 * @param src
	 * @param len
	 * @return
	 */
	public static String getSubWord(String src,int len){
		StringBuilder sb = new StringBuilder();
		char[] c = src.toCharArray();
		for(int x=0;x<c.length;x++){
			sb.append(c[x]);
			if(sb.toString().getBytes().length > len){
				return sb.substring(0,x);
			}
		}
		return src;
	}
	
	/**
	 * 转义xml特殊字符
	 * @param str
	 * @return
	 */
	public static String XmlEscape(String str) {

		if (str.indexOf("&") == -1
			&& str.indexOf("\"") == -1
			&& str.indexOf("\'") == -1 
			&& str.indexOf("<") == -1
			&& str.indexOf(">") == -1) {
			return str;
		} else {
			str = str.replaceAll("&", "&amp;");
			str = str.replaceAll("\"", "&quot;");
			str = str.replaceAll("'", "&apos;");
			str = str.replaceAll("<", "&lt;");
			str = str.replaceAll(">", "&gt;");
			return str;
		}
	}	
	

	public static void main(String argv[]) throws Exception {

	}	
}
