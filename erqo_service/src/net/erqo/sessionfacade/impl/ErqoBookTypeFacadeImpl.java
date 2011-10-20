package net.erqo.sessionfacade.impl;

import java.util.List;

import net.erqo.framework.exception.FrameworkRuntimeException;
import net.erqo.framework.sessionfacade.impl.BaseSessionFacadeImpl;
import net.erqo.model.Erqo_book_type;
import net.erqo.service.ErqoBookTypeManager;
import net.erqo.sessionfacade.ErqoBookTypeFacade;

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
public class ErqoBookTypeFacadeImpl extends BaseSessionFacadeImpl implements
		ErqoBookTypeFacade {
	
	private ErqoBookTypeManager erqoBookTypeManager;
	
	public ErqoBookTypeManager getErqoBookTypeManager() {
		return erqoBookTypeManager;
	}

	public void setErqoBookTypeManager(ErqoBookTypeManager erqoBookTypeManager) {
		this.erqoBookTypeManager = erqoBookTypeManager;
	}

	public Erqo_book_type addErqoBookType(Erqo_book_type btype)
			throws FrameworkRuntimeException {
		try{
			return null;
		}catch(Exception e){
			throw new FrameworkRuntimeException("ERRORS.A0001",e);
		}
		
	}

	public Erqo_book_type getErqoBookTypeById(Integer id)
			throws FrameworkRuntimeException {
		try{
			return null;
		}catch(Exception e){
			throw new FrameworkRuntimeException("ERRORS.A0001",e);
		}
	}

	public List<Erqo_book_type> getErqoBookTypeByParentIdList(Integer parentId)
			throws FrameworkRuntimeException {
		try{
			return null;
		}catch(Exception e){
			throw new FrameworkRuntimeException("ERRORS.A0001", e);
		}
	}

	public List<Erqo_book_type> getErqoBookTypeRootList()
			throws FrameworkRuntimeException {
		try{
			return null;
		}catch(Exception e){
			throw new FrameworkRuntimeException("ERRORS.A0001", e);
		}
	}

	public Erqo_book_type updateErqoBookType(Erqo_book_type btype)
			throws FrameworkRuntimeException {
		try{
			return null;
		}catch(Exception e){
			throw new FrameworkRuntimeException("ERRORS.A0001", e);
		}
	}

	public void updateErqoBookTypeStateById(Erqo_book_type btype)
			throws FrameworkRuntimeException {
		try{
		}catch(Exception e){
			throw new FrameworkRuntimeException("ERRORS.A0001", e);
		}
	}

}
