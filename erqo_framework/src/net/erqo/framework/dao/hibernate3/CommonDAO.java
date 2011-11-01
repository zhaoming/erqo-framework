package net.erqo.framework.dao.hibernate3;

import java.io.Serializable;
import java.util.List;

public interface CommonDAO<T, ID extends Serializable> {


	public T getObject(ID id);

	public T save(T o);

	public void deleteObjectById(ID id);
	
	public void deleteObjectForHQL(String hql, Object... args);
	
	public void deleteObjectForSQL(String hql, Object... args);

	/**
	 * 删除一个对象
	 * @param t
	 */
	public void delete(T t);

	
	public List<T> findHQL(String hql, Object... args);
	
	public void findHQLPage(PageControl pc,String hql, Object... args);
	
	public T findHQLObject(String sql, Object... args);
	
	public List<T> findSQL(String sql, Object... args);
	
	public T findSQLObject(String sql, Object... args);
	
	
	public int findHQLCount(String HQL,Object... args);
}
