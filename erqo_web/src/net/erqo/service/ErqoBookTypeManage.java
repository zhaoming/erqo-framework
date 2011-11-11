package net.erqo.service;

import java.util.List;

import net.erqo.framework.service.BaseService;
import net.erqo.model.Erqo_book_type;

public interface ErqoBookTypeManage extends BaseService {

	public List<Erqo_book_type> getErqoBookTypeByParentIdList(int parent_id);
	
	public Erqo_book_type getErqoBookTypeById(Integer id);
	
	public Erqo_book_type addErqoBookType(Erqo_book_type t);
	
}
