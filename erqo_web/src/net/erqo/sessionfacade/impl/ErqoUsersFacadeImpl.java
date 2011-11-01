package net.erqo.sessionfacade.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.erqo.framework.exception.FrameworkRuntimeException;
import net.erqo.framework.sessionfacade.impl.BaseSessionFacadeImpl;
import net.erqo.model.Erqo_users;
import net.erqo.service.ErqoUsersManage;
import net.erqo.sessionfacade.ErqoUsersFacade;

public class ErqoUsersFacadeImpl extends BaseSessionFacadeImpl implements ErqoUsersFacade {

	protected final Log logger = LogFactory.getLog(getClass());
	
	private ErqoUsersManage erqoUsersManage;
	
	public ErqoUsersManage getErqoUsersManage() {
		return erqoUsersManage;
	}

	public void setErqoUsersManage(ErqoUsersManage erqoUsersManage) {
		this.erqoUsersManage = erqoUsersManage;
	}

	public void save(Erqo_users user) {
		try{
			erqoUsersManage.save(user);
		}catch(Exception e){
			logger.info(e);
			throw new FrameworkRuntimeException("ERRORS.A0000",e);
		}

	}

	@Override
	public Erqo_users getUserByName(String loginname) {
		try{
			return erqoUsersManage.getUserByName(loginname);
		}catch(Exception e){
			logger.info(e);
			throw new FrameworkRuntimeException("ERRORS.A0000",e);
		}
	}

	@Override
	public List<Erqo_users> getUserList() {
		try{
			return erqoUsersManage.getUserList();
		}catch(Exception e){
			logger.info(e);
			throw new FrameworkRuntimeException("ERRORS.A0000",e);
		}
	}

}
