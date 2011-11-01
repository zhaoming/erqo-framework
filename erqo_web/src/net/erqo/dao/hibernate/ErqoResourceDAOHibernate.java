package net.erqo.dao.hibernate;

import java.util.List;

import net.erqo.dao.ErqoResourceDAO;
import net.erqo.framework.dao.hibernate3.CommonDAOHibernate;
import net.erqo.model.Erqo_resource;

public class ErqoResourceDAOHibernate extends
		CommonDAOHibernate<Erqo_resource, Integer, ErqoResourceDAO> implements
		ErqoResourceDAO {

	@Override
	public List<Erqo_resource> getResourceListByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return null;
	}

}
