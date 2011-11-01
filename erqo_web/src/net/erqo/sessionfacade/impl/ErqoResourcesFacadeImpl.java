package net.erqo.sessionfacade.impl;


import java.util.List;

import net.erqo.framework.sessionfacade.impl.BaseSessionFacadeImpl;
import net.erqo.model.Erqo_resource;
import net.erqo.service.ErqoResourcesManage;
import net.erqo.sessionfacade.ErqoResourcesFacade;

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
public class ErqoResourcesFacadeImpl extends BaseSessionFacadeImpl implements ErqoResourcesFacade {

	private ErqoResourcesManage erqoResourcesManage;
	
	
	public ErqoResourcesManage getErqoResourcesManage() {
		return erqoResourcesManage;
	}



	public void setErqoResourcesManage(ErqoResourcesManage erqoResourcesManage) {
		this.erqoResourcesManage = erqoResourcesManage;
	}



	public Erqo_resource getResourceById(Integer id) {
		return erqoResourcesManage.getResourceById(id);
	}



	public List<Erqo_resource> getResourceByRoleId(Integer id) {
		return erqoResourcesManage.getResourceByRoleId(id);
	}

}
