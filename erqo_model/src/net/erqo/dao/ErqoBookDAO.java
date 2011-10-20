package net.erqo.dao;

import net.erqo.framework.dao.jdbc.BaseDAO;
import net.erqo.model.Erqo_book;

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
public interface ErqoBookDAO extends BaseDAO<Erqo_book, Integer>{
	
	public Erqo_book getErqoBookList(Erqo_book book);

}
