package net.erqo.service.impl;

import java.util.List;

import net.erqo.dao.ErqoRolesDAO;
import net.erqo.framework.service.impl.BaseServiceImpl;
import net.erqo.model.Erqo_roles;
import net.erqo.service.ErqoRolesManage;

/**
 * 
 * 标题：erqo.net
 * 
 * 作者：Tony Oct 27, 2011
 * 
 * 描述：
 * 
 * 说明:
 */
public class ErqoRolesManageImpl extends BaseServiceImpl implements ErqoRolesManage {
	
	private ErqoRolesDAO erqoRolesDAO;
	
	
	
	public ErqoRolesDAO getErqoRolesDAO() {
		return erqoRolesDAO;
	}



	public void setErqoRolesDAO(ErqoRolesDAO erqoRolesDAO) {
		this.erqoRolesDAO = erqoRolesDAO;
	}



	@Override
	public List<Erqo_roles> getAll() {
		return erqoRolesDAO.findHQL("from Erqo_roles");
	}

}
