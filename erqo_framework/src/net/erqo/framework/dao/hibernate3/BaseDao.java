package net.erqo.framework.dao.hibernate3;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, ID extends Serializable> {
	/**
	 * Generic method used to get all objects of a particular type. This is the
	 * same as lookup up all rows in a table.
	 * 
	 * @param clazz
	 *            the type of objects (a.k.a. while table) to get data from
	 * @return List of populated objects
	 */
	public List<T> getObjects();

	/**
	 * Generic method to get an object based on class and identifier. An
	 * ObjectRetrievalFailureException Runtime Exception is thrown if nothing is
	 * found.
	 * 
	 * @param clazz
	 *            model class to lookup
	 * @param id
	 *            the identifier (primary key) of the class
	 * @return a populated object
	 * @see org.springframework.orm.ObjectRetrievalFailureException
	 */
	public T getObject(ID id);

	/**
	 * Generic method to save an object - handles both update and insert.
	 * 
	 * @param o
	 *            the object to save
	 */
	public T save(T o);

	public T saveObject(T o);

	/**
	 * Generic method to delete an object based on class and id
	 * 
	 * @param clazz
	 *            model class to lookup
	 * @param id
	 *            the identifier (primary key) of the class
	 */
	public void removeObject(ID id);

	/**
	 * 通过id删除一个对象
	 * 
	 * @param id
	 */
	public void delete(ID id);

	/**
	 * 删除一个对象
	 * 
	 * @param t
	 */
	public void delete(T t);

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 */
	public T findById(ID id);

	public List<T> findByExample(T exampleInstance);

	public List<T> findByProperty(String propertyName, Object value);
}
