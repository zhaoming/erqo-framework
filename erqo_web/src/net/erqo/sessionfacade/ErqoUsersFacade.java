package net.erqo.sessionfacade;

import java.util.List;

import net.erqo.framework.sessionfacade.BaseSessionFacade;
import net.erqo.model.Erqo_users;

public interface ErqoUsersFacade extends BaseSessionFacade {

	public void save(Erqo_users user);
	
	public Erqo_users getUserByName(String loginname);
	
	public List<Erqo_users> getUserList();
}
