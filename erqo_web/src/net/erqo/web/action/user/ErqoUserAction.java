package net.erqo.web.action.user;

import net.erqo.framework.web.BaseAction;
import net.erqo.model.Erqo_users;
import net.erqo.sessionfacade.ErqoUsersFacade;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;

public class ErqoUserAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2405146208238408846L;
	
	private ErqoUsersFacade erqoUsersFacade;
	
	public ErqoUsersFacade getErqoUsersFacade() {
		return erqoUsersFacade;
	}

	public void setErqoUsersFacade(ErqoUsersFacade erqoUsersFacade) {
		this.erqoUsersFacade = erqoUsersFacade;
	}

	public String login(){
		
		SecurityContextImpl secturityContext = (SecurityContextImpl) request
		.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		
		Authentication auth = secturityContext.getAuthentication();
		User user = (User) auth.getPrincipal();

		// 把用户id设置到session中
		request.getSession().setAttribute("SPRING_SECURITY_LAST_USERNAME",
				user.getUsername());
		request.getSession().setAttribute("SPRING_SECURITY_LAST_PASSWORD",
				user.getPassword());
		
		return SUCCESS;
	}
	
	public String adduser(){
		String name = request.getParameter("login_name");
		String pwd = request.getParameter("password");
		Erqo_users user = new Erqo_users();
		user.setLogin_name(name);
		user.setPassword(pwd);
		user.setEnable(1);
		erqoUsersFacade.save(user);
		return SUCCESS;
	}
	
	
	public String logout(){
		request.getSession().invalidate();
		SecurityContextHolder.clearContext();
		return SUCCESS;
	}

}
