package net.erqo.framework.dao.hibernate3;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CommonDAOHibernate<T, ID extends Serializable, DAOImpl extends CommonDAO<T, ID>>
		extends HibernateDaoSupport implements CommonDAO<T, ID> {

	protected final Log logger = LogFactory.getLog(getClass());

	@SuppressWarnings("unchecked")
	private Class persistentClass;
	
	/**
	 * @return the persistentClass
	 */
	@SuppressWarnings("unchecked")
	public Class getPersistentClass() {
		return persistentClass;
	}

	@SuppressWarnings("unchecked")
	public CommonDAOHibernate() {
		this.persistentClass = (Class) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * 保存对象
	 */
	public T save(T o) {
		getHibernateTemplate().saveOrUpdate(o);
		return o;
	}

	/**
	 * 通过id查找对象
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T getObject(ID id) {
		return (T) getHibernateTemplate().get(getPersistentClass(), id);
	}


	public void delete(T t) {
		getHibernateTemplate().delete(t);
	}
	
	public void deleteObjectById(ID id) {
		getHibernateTemplate().delete(getObject(id));
	}
	
	@Override
	public void deleteObjectForHQL(String hql, Object... args) {
		delete(findHQLObject(hql, args));
	}

	@Override
	public void deleteObjectForSQL(String sql, Object... args) {
		delete(findSQLObject(sql, args));
	}
	
	

	@SuppressWarnings("unchecked")
	public List<T> findHQL(String hql, Object... args) {
		Query query = this.getSession().createQuery(hql);
		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++)
				query.setParameter(i, args[i]);
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> findSQL(String sql, Object... args) {
		SQLQuery query = this.getSession().createSQLQuery(sql).addEntity(getPersistentClass());
		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++)
				query.setParameter(i, args[i]);
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public T findHQLObject(String sql, Object... args) {
		Query query = this.getSession().createQuery(sql);
		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++)
				query.setParameter(i, args[i]);
		}
		query.setMaxResults(1);
		return (T) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public T findSQLObject(String sql, Object... args) {
		SQLQuery query = this.getSession().createSQLQuery(sql).addEntity(getPersistentClass());
		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++)
				query.setParameter(i, args[i]);
		}
		query.setMaxResults(1);
		
		return (T) query.uniqueResult();
	}

	@Override
	public int findHQLCount(String HQL, Object... args) {
		Query query = this.getSession().createQuery(HQL);
		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++)
				query.setParameter(i, args[i]);
		}
		return ((Integer)query.uniqueResult()).intValue();
	}

	@Override
	public void findHQLPage(PageControl pageControl,String hql, Object... args) {

		int count = findHQLCount(hql,args);
		pageControl.setCount(count);
		if (count > 0) {
			Query query = this.getSession().createQuery(hql);

			if (args != null && args.length > 0) {
				for (int i = 0; i < args.length; i++)
					query.setParameter(i, args[i]);
			}

			query.setMaxResults(pageControl.getPageSize());
			query.setFirstResult(pageControl.getBegin());
			pageControl.setList(query.list());
		}
	}


}