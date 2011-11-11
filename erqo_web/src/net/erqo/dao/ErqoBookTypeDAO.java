package net.erqo.dao;

import java.util.List;

import net.erqo.framework.dao.hibernate3.CommonDAO;
import net.erqo.model.Erqo_book_type;

public interface ErqoBookTypeDAO extends CommonDAO<Erqo_book_type, Integer> {
	
	public List<Erqo_book_type> getErqoBookTypeByParentIdList(int parent_id);
	
	public Erqo_book_type addErqoBookType(Erqo_book_type t);

}
