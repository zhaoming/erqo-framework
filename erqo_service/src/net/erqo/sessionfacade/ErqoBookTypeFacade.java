package net.erqo.sessionfacade;

import java.util.List;

import net.erqo.framework.exception.FrameworkRuntimeException;
import net.erqo.framework.sessionfacade.BaseSessionFacade;
import net.erqo.model.Erqo_book_type;

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
public interface ErqoBookTypeFacade extends BaseSessionFacade {
	
	/**
	 * 增加分类
	 * @param Erqo_book_type btype
	 * @return Erqo_book_type
	 */
	public Erqo_book_type addErqoBookType(Erqo_book_type btype) throws FrameworkRuntimeException;
	
	/**
	 * 修改分类
	 * @param  Erqo_book_type btype
	 * @return Erqo_book_type
	 */
	public Erqo_book_type updateErqoBookType(Erqo_book_type btype) throws FrameworkRuntimeException;
	
	/**
	 * 修改状态
	 * @param Erqo_book_type btype
	 */
	public void updateErqoBookTypeStateById(Erqo_book_type btype) throws FrameworkRuntimeException;
	
	/**
	 * 取分类
	 * @param btype
	 * @return Erqo_book_type
	 */
	public Erqo_book_type getErqoBookTypeById(Integer id) throws FrameworkRuntimeException;
	
	/**
	 * 取根
	 * @return List<Erqo_book_type>
	 */
	public List<Erqo_book_type> getErqoBookTypeRootList() throws FrameworkRuntimeException;
	
	/**
	 * 通过父ID取一下级
	 * @param Integer parentId
	 * @return List<Erqo_book_type>
	 */
	public List<Erqo_book_type> getErqoBookTypeByParentIdList(Integer parentId) throws FrameworkRuntimeException;

}
