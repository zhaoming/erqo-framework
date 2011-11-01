package net.erqo.dao;

import java.util.List;

import net.erqo.framework.dao.hibernate3.CommonDAO;
import net.erqo.model.Erqo_resource;

public interface ErqoResourceDAO extends CommonDAO<Erqo_resource, Integer> {
	
	public List<Erqo_resource> getResourceListByRoleId(Integer role_id);

}
