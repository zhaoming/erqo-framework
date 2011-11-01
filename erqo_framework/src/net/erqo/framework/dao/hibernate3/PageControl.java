package net.erqo.framework.dao.hibernate3;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 搜索优化类
 * </p>
 * 此类针对那些重量级对象的搜索或者在搜索结果数量超过1K时<br>
 * 此类优化从两方面:<br>
 * 1:基于JDBC2.0或者更高版本，实现了ResultSet的移动游标指针last(),absolute(),getRow()等方法。<br>
 * 2:基于DBMS支持从结果集中取中间某一段数据。例如MYSQL的limit m,n<br>
 * 有两种不同的方法来实现<br>
 * <br>
 * 1:利用SQL的COUNT(*)计算出结果的总行数。然后计算应取出的数据的位置，然后取特定的数据。<br>
 * 2:利用ResultSet的last()和getRow()得到总记录数，然后移动指针到要取的数据的位置,然后取出相应的数据。<br>
 * <br>
 * 两种方法优缺点都很明显<br>
 * 第一种方法要执行两次SQL，如果表连接较多则较慢－－也就是说，要多费将近一倍的时间在执行统计记录总条数上。<br>
 * 第二重方法要花费较多的IO，如果取出的字段较多则较慢－－因为要将检索全部的结果。<br>
 * 较好的办法是利用第二种方法检索出对象的标志，然后利用这些对象标志检索对象信息。 这样作的弊端是列表的对象的排列顺序可能和预期的顺序不一致。<br>
 * <br>
 * 第二种方法时间复杂度和要检索的数据的位置无关。－－取第一页和最后一页所花时间一样。<br>
 * 例子 ：SearchDemo 你们自己看者办吧。
 * <p>
 * Copyright 2002(c)xinhuabookstore.com
 * </p>
 * <p>
 * Company: 新华在线网络有限责任公司
 * </p>
 * <p>
 * 2003年8月5日
 * </p>
 * 
 * @author GongShuTao
 * @version 1.0
 */

public class PageControl {
	public static int PAGESIZE = 20;

	/**
	 * 每页对象数
	 */
	private int pageSize = PAGESIZE;

	/**
	 * 页数
	 */
	private int pageCount = 0;

	/**
	 * 对象数
	 */
	private int count = 0;

	/**
	 * 当前页
	 */
	private int currentPage = 1;

	/**
	 * 当前页开始的记录的位置
	 */
	private int begin = 0;

	/**
	 * 当前页结束的记录的位置
	 */
	private int end = 0;

	/**
	 * 结果
	 */
	private List<?> list = null;

	private String appendParams = "";

	/**
	 * 当前快近所在页面
	 */
	private int currentSkip = 1;

	private int skipSize = 10;

	public PageControl(int defaultPageSize) {
		this.pageSize = defaultPageSize;
	}

	public PageControl(int defaultPageSize, int page) {
		this.pageSize = defaultPageSize;
		this.currentPage = page;
	}

	/**
	 * @deprecated
	 * @param request
	 *            HttpServletRequest
	 */
	public PageControl(HttpServletRequest request) {
		init(request);
	}

	public PageControl(HttpServletRequest request, int defaultPageSize) {
		this.pageSize = defaultPageSize;
		init(request);
	}

	public PageControl(HttpServletRequest request, int pageIndex,
			int defaultPageSize) {
		this.pageSize = defaultPageSize;
		init(request);
		this.currentPage = pageIndex;
	}

	protected void init(HttpServletRequest request) {
		currentPage = 1;
		String page = request.getParameter("page");
		String s_pageSize = request.getParameter("pageSize");
		if (page != null) {
			try {
				currentPage = Integer.valueOf(page).intValue();
				if (currentPage <= 0)
					currentPage = 1;
			} catch (Exception e) {
			}
		}
		if (s_pageSize != null) {
			try {
				if (Integer.valueOf(s_pageSize).intValue() > 0)
					this.pageSize = Integer.valueOf(s_pageSize).intValue();
			} catch (Exception e) {
			}
		}
		appendParams = request.getQueryString();
		if (appendParams != null) {
			appendParams = appendParams.replaceAll("page=" + getCurrentPage(),
					"");
			appendParams = appendParams.replaceAll("&pageSize=" + getPageSize()
					+ "&", "");
			if (appendParams.indexOf("&") != 0)
				appendParams = "&" + appendParams;
		} else
			appendParams = "";
		request.setAttribute("pageControl", this);
	}

	/**
	 * 返回当前页
	 * 
	 * @return 当前页
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * 得到页数
	 * 
	 * @return 页数
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * 得到每页记录条数
	 * 
	 * @return 每页记录条数
	 */
	public int getPageSize() {
		return this.pageSize;
	}

	/**
	 * 得到记录条数
	 * 
	 * @return 记录条数
	 */
	public int getCount() {
		return count;
	}

	/**
	 * 得到当前页的记录开始位置
	 * 
	 * @return 开始位置
	 */
	public int getBegin() {
		return begin;
	}

	/**
	 * 得到记录的结束位置
	 * 
	 * @return 结束位置
	 */
	public int getEnd() {
		return end;
	}

	@SuppressWarnings("unchecked")
	public List getList() {
		if (list == null)
			list = new ArrayList();
		return list;
	}

	public String getAppendParams() {
		return appendParams;
	}

	/**
	 * 设置记录条数
	 * 
	 * @param count
	 *            int
	 */
	public void setCount(int count) {
		if (count <= 0)
			return;
		this.count = count;
		this.pageCount = count / pageSize + ((count % pageSize == 0) ? 0 : 1);
		if (currentPage > pageCount)
			currentPage = pageCount;
		if (currentPage <= 0)
			currentPage = 1;

		begin = (currentPage - 1) * pageSize;
		end = currentPage * pageSize;
		if (end >= count)
			end = count;

		currentSkip = (currentPage / skipSize) * skipSize + 1;
		if (currentPage % skipSize == 0)
			currentSkip = currentSkip - skipSize;
	}

	/**
	 * 是否可以到第一页
	 * 
	 * @return boolean
	 */
	public boolean getCanGoFirst() {
		return (this.currentPage > 1);
	}

	/**
	 * 是否可以到前一页
	 * 
	 * @return boolean
	 */
	public boolean getCanGoPrevious() {
		return (this.currentPage > 1);
	}

	/**
	 * 是否可以到下一页
	 * 
	 * @return boolean
	 */
	public boolean getCanGoNext() {
		return (this.currentPage <= this.pageCount);
	}

	/**
	 * 是否可以到最后一页
	 * 
	 * @return boolean
	 */
	public boolean getCanGoLast() {
		return (this.currentPage < this.pageCount);
	}

	/**
	 * 得到前一页页码
	 * 
	 * @return int
	 */
	public int getPrevious() {
		if (this.currentPage > 1)
			return this.currentPage - 1;
		else
			return 1;
	}

	/**
	 * 得到下一页页码
	 * 
	 * @return int
	 */
	public int getNext() {
		if (this.currentPage < this.pageCount)
			return this.currentPage + 1;
		else
			return this.pageCount;
	}

	/**
	 * 填充对象
	 * 
	 * @param objectList
	 *            List
	 */
	public void setAll(List<?> objectList) {
		if (objectList != null) {
			this.setCount(objectList.size());
			list = objectList.subList(this.getBegin(), this.getEnd());
		} else {
			this.setCount(0);
		}
	}

	/**
	 * 
	 * @param list
	 *            List
	 */
	public void setList(List<?> list) {
		this.list = list;
	}

	public void setAppendParams(String appendParams) {
		this.appendParams = appendParams;
	}

	/**
	 * 是否可以向前快进
	 * 
	 * @return boolean
	 */
	public boolean getCanSkipPrevious() {
		return getSkipPrevious() > 0;
	}

	/**
	 * 得到向前快近的页码
	 * 
	 * @return int
	 */
	public int getSkipPrevious() {
		return this.currentSkip - skipSize;
	}

	/**
	 * 是否可以向后快进
	 * 
	 * @return boolean
	 */
	public boolean getCanSkipNext() {
		return (getSkipNext() <= this.pageCount);
	}

	/**
	 * 得到向后快近的页码
	 * 
	 * @return int
	 */
	public int getSkipNext() {
		return this.currentSkip + skipSize;
	}

	/**
	 * 得到当前显示的页码
	 * 
	 * @return int[]
	 */
	public int[] getCurrentSkipPageNumbers() {
		int count = skipSize;
		if (currentSkip + skipSize > pageCount)
			count = pageCount - currentSkip + 1;
		int[] Result = new int[count];
		for (int i = 0; i < count; i++) {
			Result[i] = currentSkip + i;
		}
		return Result;
	}

	/**
	 * 向后翻页
	 */
	public void goNext() {
		if (getCanGoNext()) {
			currentPage++;
			begin = (currentPage - 1) * pageSize;
			end = currentPage * pageSize;
		}
	}

	/**
	 * 向前翻页
	 */
	public void goPrevious() {
		if (getCanGoPrevious()) {
			currentPage--;
			begin = (currentPage - 1) * pageSize;
			end = currentPage * pageSize;
		}
	}
}
