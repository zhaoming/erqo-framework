package net.erqo.dao.jdbc;

import java.util.List;

import net.erqo.dao.ErqoBookDAO;
import net.erqo.framework.dao.jdbc.AbstractBaseJDBCDAO;
import net.erqo.framework.utils.PageUtil;
import net.erqo.model.Erqo_book;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

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
public class ErqoBookJDBCDAO extends AbstractBaseJDBCDAO<Erqo_book, Integer>
		implements ErqoBookDAO {

	public Erqo_book getErqoBookList(Erqo_book book) {
		Erqo_book rbook = new Erqo_book();
		List<Erqo_book> list = getJdbcTemplate()
				.query(
						PageUtil.getPageMySql("select * from erqo_book", book
								.getCurrentPage(), book.getPageSize()),
						ParameterizedBeanPropertyRowMapper
								.newInstance(Erqo_book.class));
		rbook.setList(list);
		rbook.setTotal(getsize(book));
		return rbook;
	}

	private int getsize(Erqo_book book) {
		return getJdbcTemplate().queryForInt("select count(1) from erqo_book");
	}

}
