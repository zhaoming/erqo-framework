package net.erqo.framework.dao.hibernate3;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDAOHibernate<T, ID extends Serializable, DAOImpl extends BaseDao<T, ID>>
		extends HibernateDaoSupport implements BaseDao<T, ID> {

	protected final Log logger = LogFactory.getLog(getClass());

	@SuppressWarnings("unchecked")
	private Class persistentClass;

	@SuppressWarnings("unchecked")
	public BaseDAOHibernate() {
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
	 * 保存对象
	 */
	public T saveObject(T o) {
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

	public List<T> getObjects() {
		return findByCriteria();
	}

	public void removeObject(ID id) {
		getHibernateTemplate().delete(getObject(id));
	}

	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(final Criterion... criterion) {
		return (List<T>) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) {
						Criteria crit = session
								.createCriteria(getPersistentClass());
						for (Criterion c : criterion) {
							crit.add(c);
						}
						return crit.list();
					}
				});
	}

	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(final int firstResult, final int rowCount,
			final Order order, final Criterion... criterion) {
		return (List<T>) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) {
						Criteria crit = session
								.createCriteria(getPersistentClass());
						for (Criterion c : criterion) {
							crit.add(c);
						}
						if (order != null)
							crit.addOrder(order);
						crit.setFirstResult(firstResult);
						crit.setMaxResults(rowCount);
						return crit.list();
					}
				});
	}

	/**
	 * @return the persistentClass
	 */
	@SuppressWarnings("unchecked")
	public Class getPersistentClass() {
		return persistentClass;
	}

	@SuppressWarnings("unchecked")
	public List<T> findByExample(final T exampleInstance) {
		return (List<T>) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) {
						Criteria crit = session
								.createCriteria(getPersistentClass());
						Example example = Example.create(exampleInstance);
						crit.add(example);
						return crit.list();
					}
				});
	}

	@SuppressWarnings("unchecked")
	public List<T> findByExample(final T exampleInstance,
			final String[] excludeProperty) {
		return (List<T>) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) {
						Criteria crit = session
								.createCriteria(getPersistentClass());
						Example example = Example.create(exampleInstance);
						for (String exclude : excludeProperty) {
							example.excludeProperty(exclude);
						}
						crit.add(example);
						return crit.list();
					}
				});
	}

	public T makePersistent(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
		return entity;
	}

	public void makeTransient(T entity) {
		getHibernateTemplate().delete(entity);
	}

	/**
	 * 删除对象
	 */
	public void delete(ID id) {
		removeObject(id);
	}

	public void delete(T t) {
		getHibernateTemplate().delete(t);

	}

	public T findById(ID id) {
		return getObject(id);
	}

	public List<T> findAll() {
		return getObjects();
	}

	/**
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByProperty(final String propertyName, final Object value) {
		return (List<T>) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) {
						Property prop = Property.forName(propertyName);
						Criteria cr = session
								.createCriteria(getPersistentClass());
						cr.add(prop.eq(value));
						return cr.list();
					}
				});
	}
}