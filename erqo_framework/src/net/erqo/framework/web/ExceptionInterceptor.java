package net.erqo.framework.web;

import net.erqo.framework.exception.FrameworkRuntimeException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 
 * 标题：ERQO.NET
 * 
 * 作者：tony 2010-8-27
 * 
 * 描述：
 * 
 * 说明:
 */
public class ExceptionInterceptor implements Interceptor {

	private static final long serialVersionUID = 6848156194108832900L;
	protected final Log logger = LogFactory.getLog(getClass());
	
	private static final String FAILURE = "failure";
	
	private String ErrorCode = "ERRORS.A0000";

	@Override
	public void destroy() {

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception

	{

		String result = "";
		try {
			result = invocation.invoke();
		} catch (Exception ex) {
			ActionSupport actionSupport = (ActionSupport) invocation
					.getAction();
			exception(ex, actionSupport);
			result = FAILURE;
		}
		return result;

	}

	private void exception(Exception e, ActionSupport actionSupport)
			throws Exception {
		
		if (e instanceof FrameworkRuntimeException) {
				FrameworkRuntimeException be = (FrameworkRuntimeException) e;
			if (logger.isErrorEnabled()) {
				logger.error("[" + be.getErrorCode() + "] " + ": ", be);
			}
			ErrorCode = actionSupport.getText(be.getErrorCode());
			
			//String errorType = actionSupport.getText(be.getErrorCode(), new String[] { ErrorCode, be.getMessage() });
			
			actionSupport.addActionError(ErrorCode);
		} else {
			if (logger.isErrorEnabled()) {
				logger.error("未知异常: ", e);
			}
			ErrorCode = actionSupport.getText(ErrorCode);
			actionSupport.addActionError(ErrorCode);
		}
	}

}
