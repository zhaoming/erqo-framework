package net.erqo.sessionfacade;

import java.util.List;

import net.erqo.framework.sessionfacade.BaseSessionFacade;
import net.erqo.model.Erqo_book_type;

public interface ErqoBookTypeFacade extends BaseSessionFacade {

	
	public List<Erqo_book_type> getErqoBookTypeByParentIdList(int parent_id);
	
	public Erqo_book_type getErqoBookTypeById(Integer id);
	
	public Erqo_book_type addErqoBookType(Erqo_book_type t);
	
}
