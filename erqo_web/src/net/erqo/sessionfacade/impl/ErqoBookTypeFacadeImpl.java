package net.erqo.sessionfacade.impl;

import java.util.List;

import net.erqo.framework.sessionfacade.impl.BaseSessionFacadeImpl;
import net.erqo.model.Erqo_book_type;
import net.erqo.service.ErqoBookTypeManage;

public class ErqoBookTypeFacadeImpl extends BaseSessionFacadeImpl implements
		net.erqo.sessionfacade.ErqoBookTypeFacade {

	private ErqoBookTypeManage erqoBookTypeManage;
	
	public ErqoBookTypeManage getErqoBookTypeManage() {
		return erqoBookTypeManage;
	}
	
	public void setErqoBookTypeManage(ErqoBookTypeManage erqoBookTypeManage) {
		this.erqoBookTypeManage = erqoBookTypeManage;
	}


	@Override
	public List<Erqo_book_type> getErqoBookTypeByParentIdList(int parentId) {
		return erqoBookTypeManage.getErqoBookTypeByParentIdList(parentId);
	}

	@Override
	public Erqo_book_type getErqoBookTypeById(Integer id) {
		return erqoBookTypeManage.getErqoBookTypeById(id);
	}

	@Override
	public Erqo_book_type addErqoBookType(Erqo_book_type t) {
		return erqoBookTypeManage.addErqoBookType(t);
	}

}
