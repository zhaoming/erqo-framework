package net.erqo.service.impl;

import java.util.List;

import net.erqo.dao.ErqoBookTypeDAO;
import net.erqo.framework.service.impl.BaseServiceImpl;
import net.erqo.model.Erqo_book_type;
import net.erqo.service.ErqoBookTypeManage;

public class ErqoBookTypeManageImpl extends BaseServiceImpl implements ErqoBookTypeManage {
	
	private ErqoBookTypeDAO erqoBookTypeDAO;
	
	
	public ErqoBookTypeDAO getErqoBookTypeDAO() {
		return erqoBookTypeDAO;
	}



	public void setErqoBookTypeDAO(ErqoBookTypeDAO erqoBookTypeDAO) {
		this.erqoBookTypeDAO = erqoBookTypeDAO;
	}



	@Override
	public List<Erqo_book_type> getErqoBookTypeByParentIdList(int parentId) {
		return erqoBookTypeDAO.getErqoBookTypeByParentIdList(parentId);
	}



	@Override
	public Erqo_book_type getErqoBookTypeById(Integer id) {
		return erqoBookTypeDAO.getObject(id);
	}



	@Override
	public Erqo_book_type addErqoBookType(Erqo_book_type t) {
		return erqoBookTypeDAO.addErqoBookType(t);
	}

}
