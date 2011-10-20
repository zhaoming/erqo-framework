package net.erqo.framework.dao.common;

import java.io.Serializable;

import net.erqo.framework.dao.hibernate3.BaseDAOHibernate;
import net.erqo.framework.dao.hibernate3.BaseDao;

public class CommonDAOHibernate<T, ID extends Serializable, DAOImpl extends BaseDao<T, ID>>
		extends BaseDAOHibernate<T, ID, DAOImpl> {

	public CommonDAOHibernate() {
		super();
	}

	/**
	 * 获取总记录数
	 * 
	 * @param sql
	 * @return
	 */
	protected String getCountSQL(String sql) {
		return new StringBuffer("select count(c.*) as count from (")
				.append(sql).append(") c").toString();
	}

	/**
	 * 分页查询
	 * 
	 * @param sql
	 * @param columns
	 * @param start
	 * @param end
	 * @return
	 */
	protected String getPageSQL(String sql, String[] columns, int start, int end) {
		if (columns == null || end < start)
			return null;
		StringBuffer sb = new StringBuffer("select");

		// 显示条件
		for (int i = 0; i < columns.length; i++) {
			if (i > 0)
				sb.append(",");
			sb.append(" a.");
			sb.append(columns[i]);
			sb.append(" ");
		}

		sb.append("from ( ");

		sb.append(sql);

		sb.append(") a limit ");
		sb.append(start);
		sb.append(" , ");
		sb.append(end);

		return sb.toString();
	}

	/**
	 * 分页查询
	 * 
	 * @param sql
	 * @param start
	 * @param end
	 * @return
	 */
	protected String getPageSQL(String sql, int start, int end) {
		if (end < start)
			return null;
		StringBuffer sb = new StringBuffer("select a.* from ( ");
		sb.append(sql);
		sb.append(") a limit ");
		sb.append(start);
		sb.append(" , ");
		sb.append(end);

		return sb.toString();
	}

}
