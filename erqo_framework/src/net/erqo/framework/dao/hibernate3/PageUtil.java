package net.erqo.framework.dao.hibernate3;

import java.util.List;

/**
 * 
 * 标题：erqo.net
 * 
 * 作者：Tony Oct 31, 2011
 * 
 * 描述：
 * 
 * 说明:
 */
public class PageUtil {
	
	private int total;
	
	private int pageSize;
	
	private int currentPage;
	
	private List<?> list;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
}
