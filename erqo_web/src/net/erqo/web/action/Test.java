package net.erqo.web.action;
/**
 * 
 * 标题：ERQO.NET
 * 
 * 作者：Tony 2010-12-30
 * 
 * 描述：
 * 
 * 说明:
 */
public class Test {
	public static void main(String args[]){
		String code = "0000";
		System.out.println(code.substring(code.length()-4));
		System.out.println(Integer.parseInt(code.substring(code.length()-4)));
	}
}
