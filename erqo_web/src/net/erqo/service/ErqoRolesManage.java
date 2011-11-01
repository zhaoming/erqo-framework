package net.erqo.service;

import java.util.List;

import net.erqo.framework.service.BaseService;
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
public interface ErqoRolesManage  extends BaseService {
	
	public List<Erqo_roles> getAll();
}
