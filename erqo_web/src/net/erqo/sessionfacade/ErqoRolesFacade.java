package net.erqo.sessionfacade;

import java.util.List;

import net.erqo.framework.sessionfacade.BaseSessionFacade;
import net.erqo.model.Erqo_roles;

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
public interface ErqoRolesFacade extends BaseSessionFacade{
	
	public List<Erqo_roles> getAll();

}
