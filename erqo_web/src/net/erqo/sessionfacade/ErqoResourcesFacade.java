package net.erqo.sessionfacade;

import java.util.List;

import net.erqo.framework.sessionfacade.BaseSessionFacade;
import net.erqo.model.Erqo_resource;

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
public interface ErqoResourcesFacade extends BaseSessionFacade {
	
	public Erqo_resource getResourceById(Integer id);
	
	public List<Erqo_resource> getResourceByRoleId(Integer id);

}
