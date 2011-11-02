/**
 * 
 */
package net.erqo.framework.utils;

/**
 * @author 吉凤祥 用于生成树节点的code
 * 
 */
public class CodeGenerator {

	/**
	 * code生成器
	 * 
	 * @param parentCode
	 *            父节点code
	 * @param maxCode
	 *            平级最大的code
	 * 
	 * @return
	 */
	public static String genratorCode(String parentCode, String maxCode) {
		int seq = 0;
		if(maxCode == null || maxCode.equals("0")){
			seq = 1;
			maxCode = parentCode + "0000";
		}
		
		// maxCode的下一seq
		seq = Integer.parseInt(maxCode
				.substring(parentCode.length())) + 1;

		// 根据顺序算出最终的code
		String seqStr = String.valueOf(seq);

		int len = seqStr.length();
		for (int i = 0; i < 4 - len; i++) 
			seqStr = "0" + seqStr;		
		

		// 没有父节点，那肯定是第一级的
		seqStr = parentCode.equals("0") ? seqStr : parentCode + seqStr;

		return seqStr;
	}

	public static void main(String[] str) {
		System.out.println(genratorCode("0", null));
	}

}
