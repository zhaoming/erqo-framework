package net.erqo.service.impl;

import java.util.List;

import net.erqo.dao.ErqoUsersDAO;
import net.erqo.framework.service.impl.BaseServiceImpl;
import net.erqo.model.Erqo_users;
import net.erqo.service.ErqoUsersManage;

public class ErqoUsersManageImpl extends BaseServiceImpl implements ErqoUsersManage {

	private ErqoUsersDAO erqoUsersDAO;
	
	
	public void save(Erqo_users user) {
		erqoUsersDAO.save(user);
	}

	public void setErqoUsersDAO(ErqoUsersDAO erqoUsersDAO) {
		this.erqoUsersDAO = erqoUsersDAO;
	}

	public ErqoUsersDAO getErqoUsersDAO() {
		return erqoUsersDAO;
	}

	public Erqo_users getUserByName(String name) {
		return (Erqo_users) erqoUsersDAO.findHQLObject("from Erqo_users where login_name = ?", name);
	}

	@Override
	public List<Erqo_users> getUserList() {
		return erqoUsersDAO.findHQL("from Erqo_users", null);
	}

}
