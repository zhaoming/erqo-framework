package net.erqo.framework.model;
/**
 * 
 * 标题：ERQO.NET
 * 
 * 作者：Tony 2011-1-5
 * 
 * 描述：
 * 
 * 说明:
 */
public class Pager {
	
	private int offset;
	
	private int maxPageItems;

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getMaxPageItems() {
		return maxPageItems;
	}

	public void setMaxPageItems(int maxPageItems) {
		this.maxPageItems = maxPageItems;
	}
}
