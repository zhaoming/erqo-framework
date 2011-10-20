package net.erqo.service.impl;

import java.util.List;

import net.erqo.dao.ErqoArticleCategoryDAO;
import net.erqo.dao.ErqoBookTypeDAO;
import net.erqo.framework.service.impl.BaseServiceImpl;
import net.erqo.model.Erqo_book_type;
import net.erqo.service.ErqoBookTypeManager;

/**
 * 
 * 标题：ERQO.NET
 * 
 * 作者：Tony 2010-12-31
 * 
 * 描述：
 * 
 * 说明:
 */
public class ErqoBookTypeManagerImpl extends BaseServiceImpl implements
		ErqoBookTypeManager {

	private ErqoArticleCategoryDAO ErqoArticleCategoryDAO;
	
	public ErqoArticleCategoryDAO getErqoArticleCategoryDAO() {
		return ErqoArticleCategoryDAO;
	}

	public void setErqoArticleCategoryDAO(
			ErqoArticleCategoryDAO erqoArticleCategoryDAO) {
		ErqoArticleCategoryDAO = erqoArticleCategoryDAO;
	}

	public ErqoBookTypeDAO getErqoBookTypeDAO() {
		return null;
	}

	public Erqo_book_type addErqoBookType(Erqo_book_type btype) {
		ErqoArticleCategoryDAO.save(btype);
		return btype;
	}

	public Erqo_book_type getErqoBookTypeById(Integer id) {
		return null;
	}

	public List<Erqo_book_type> getErqoBookTypeByParentIdList(Integer parentId) {
		return null;
	}

	public List<Erqo_book_type> getErqoBookTypeRootList() {
		return null;
	}

	public Erqo_book_type updateErqoBookType(Erqo_book_type btype) {
		return null;
	}

	public void updateErqoBookTypeStateById(Erqo_book_type btype) {
	}

}
