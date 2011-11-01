package net.erqo.service;

import java.util.List;

import net.erqo.framework.service.BaseService;
import net.erqo.model.Erqo_users;

public interface ErqoUsersManage  extends BaseService {
	
	public void save(Erqo_users user);
	
	public Erqo_users getUserByName(String name);
	
	public List<Erqo_users> getUserList();

}
