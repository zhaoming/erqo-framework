package net.erqo.model;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * 标题：ERQO.NET
 * 
 * 作者：Tony 2011-1-5
 * 
 * 描述：
 * 
 * 说明:
 * @param <T>
 */
public abstract class AbstactBean<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1145752940185957169L;

	private int total;
	
	private int pageSize;
	
	private int currentPage;
	
	private List<T> list;

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

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
