package net.erqo.service.impl;

import java.util.List;

import net.erqo.dao.ErqoResourceDAO;
import net.erqo.framework.service.impl.BaseServiceImpl;
import net.erqo.model.Erqo_resource;
import net.erqo.service.ErqoResourcesManage;

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
public class ErqoResourcesManageImpl extends BaseServiceImpl implements ErqoResourcesManage {

	private ErqoResourceDAO erqoResourceDAO;
	
	
	
	public ErqoResourceDAO getErqoResourceDAO() {
		return erqoResourceDAO;
	}



	public void setErqoResourceDAO(ErqoResourceDAO erqoResourceDAO) {
		this.erqoResourceDAO = erqoResourceDAO;
	}



	@Override
	public Erqo_resource getResourceById(Integer id) {
		return erqoResourceDAO.getObject(id);
	}



	@Override
	public List<Erqo_resource> getResourceByRoleId(Integer id) {
		return erqoResourceDAO.findSQL("select r.* from Erqo_role_resource rr, Erqo_resources r where rr.resource_id = r.id and rr.role_id = ?", id);
	}

}
