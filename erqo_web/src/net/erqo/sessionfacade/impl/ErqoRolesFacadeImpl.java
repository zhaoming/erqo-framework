package net.erqo.sessionfacade.impl;

import java.util.List;

import net.erqo.framework.sessionfacade.impl.BaseSessionFacadeImpl;
import net.erqo.model.Erqo_roles;
import net.erqo.service.ErqoRolesManage;
import net.erqo.sessionfacade.ErqoRolesFacade;

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
public class ErqoRolesFacadeImpl extends BaseSessionFacadeImpl implements ErqoRolesFacade {

	private ErqoRolesManage erqoRolesManage;
	
	public ErqoRolesManage getErqoRolesManage() {
		return erqoRolesManage;
	}

	public void setErqoRolesManage(ErqoRolesManage erqoRolesManage) {
		this.erqoRolesManage = erqoRolesManage;
	}



	public List<Erqo_roles> getAll() {
		return erqoRolesManage.getAll();
	}

}
