package net.erqo.dao;

import java.util.List;

import net.erqo.framework.dao.jdbc.BaseDAO;
import net.erqo.model.Erqo_book_type;

/**
 * 
 * 标题：ERQO.NET
 * 
 * 作者：Tony 2010-12-30
 * 
 * 描述：
 * 
 * 说明:
 */
public interface ErqoBookTypeDAO extends BaseDAO<Erqo_book_type, Integer> {

	/**
	 * 增加分类
	 * @param Erqo_book_type btype
	 * @return Erqo_book_type
	 */
	public Erqo_book_type addErqoBookType(Erqo_book_type btype);
	
	/**
	 * 修改分类
	 * @param  Erqo_book_type btype
	 * @return Erqo_book_type
	 */
	public Erqo_book_type updateErqoBookType(Erqo_book_type btype);
	
	/**
	 * 修改状态
	 * @param Erqo_book_type btype
	 */
	public void updateErqoBookTypeStateById(Erqo_book_type btype);
	
	/**
	 * 取分类
	 * @param btype
	 * @return Erqo_book_type
	 */
	public Erqo_book_type getErqoBookTypeById(Integer id);
	
	/**
	 * 取根
	 * @return List<Erqo_book_type>
	 */
	public List<Erqo_book_type> getErqoBookTypeRootList();
	
	/**
	 * 通过父ID取一下级
	 * @param Integer parentId
	 * @return List<Erqo_book_type>
	 */
	public List<Erqo_book_type> getErqoBookTypeByParentIdList(Integer parentId);
	
}
