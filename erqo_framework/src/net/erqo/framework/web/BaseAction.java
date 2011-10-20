package net.erqo.framework.web;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.erqo.framework.model.Pager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport implements SessionAware,
		ServletRequestAware, ServletResponseAware, ServletContextAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7989895382692112121L;

	protected final Log logger = LogFactory.getLog(getClass());

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	protected Map<String, Object> session;
	
	protected ServletContext context;   
	
	private Pager pager;
	
	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	@Override
	public void setSession(Map<String, Object> _session) {
		this.session = _session;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest _request) {
		this.request = _request;
	}

	@Override
	public void setServletResponse(HttpServletResponse _response) {
		this.response = _response;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
		
	}
	
	public void initPager(int pageSize){
		if(getPager()==null){
			Pager p = new Pager();
			p.setMaxPageItems(pageSize);
			p.setOffset(0);
			setPager(p);
		}  else if(getPager().getMaxPageItems()==0){
			getPager().setMaxPageItems(pageSize);
		}
		
	}
	
	
	
}
