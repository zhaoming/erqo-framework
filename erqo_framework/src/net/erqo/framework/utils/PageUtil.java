package net.erqo.framework.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.GenericValidator;


/**
 * 
 * 标题：EROQ.NET
 * 
 * 作者：TONY 2008 12 17
 * 
 * 描述：
 * 
 * 说明:
 */
public class PageUtil {

	/**
	 * 取得当前页
	 * 
	 * @param id
	 * @return
	 */
	public static Integer getPageIndex(HttpServletRequest request)
			throws Exception {
		try {
			return GenericValidator.isBlankOrNull(request.getParameter("page")) ? 1
					: (Integer.parseInt(request.getParameter("page")));
		} catch (NumberFormatException ne) {
			throw new Exception("", ne);
		}
	}

	/**
	 * 取页面显示数据条数
	 * @param request,size 每页显示条数 
	 * @return
	 * @throws FrameworkException
	 */
	public static Integer getPageSize(HttpServletRequest request,int size)
			throws Exception {
		int size_ = 20;
		if(size != 0){
			size_ = size;
		}
		
		try {
			return  GenericValidator.isBlankOrNull(request
					.getParameter("pagesize")) ? size_ : (Integer
							.parseInt(request.getParameter("pagesize")));
			
		} catch (NumberFormatException ne) {
			throw new Exception("", ne);
		}
	}

	
	/**
	 * 根据每页大小 当前页 生成sql For mysql
	 * 
	 * @param sql
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */	
	public static String getPageMySql(String sql, int currentPage, int pageSize) {
		StringBuffer sb = new StringBuffer();
		sb.append(sql);
		sb.append(" limit ");
		sb.append(currentPage);
		sb.append(",");
		sb.append(pageSize);
		return sb.toString();
	}
		
	/**
	 * 根据每页大小 当前页 生成sql For oracle
	 * 
	 * @param sql
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */	
	public static String getPageOraSql(String sql, int pageSize, int currentPage) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from(select row_.*, rownum rownum_ from(");
		sb.append(sql);
		sb.append(") row_ where rownum<=");
		sb.append(pageSize * currentPage);
		sb.append(") where rownum_>");
		sb.append(pageSize * (currentPage - 1));
		return sb.toString();
	}
}
