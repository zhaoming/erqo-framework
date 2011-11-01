package net.erqo.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

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
public class FilterSecurityInterceptor extends AbstractSecurityInterceptor
		implements Filter {
	
	private FilterInvocationSecurityMetadataSource securityMetadataSource;
	
	public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {  
        return this.securityMetadataSource;  
    }
	
	public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource securityMetadataSource) {  
        this.securityMetadataSource = securityMetadataSource;  
    }  
	
	public Class<? extends Object> getSecureObjectClass() {
		return FilterInvocation.class;  
	}

	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.securityMetadataSource;  
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (logger.isDebugEnabled()) {  
            logger.debug("doFilter(ServletRequest, ServletResponse, FilterChain) - start"); //$NON-NLS-1$  
        }  
        FilterInvocation fi = new FilterInvocation(request, response, chain);  
        invoke(fi);  
        if (logger.isDebugEnabled()) {  
            logger.debug("doFilter(ServletRequest, ServletResponse, FilterChain) - end"); //$NON-NLS-1$  
        } 

	}
	
    public void invoke(FilterInvocation fi) throws IOException, ServletException {  
        InterceptorStatusToken token = super.beforeInvocation(fi);  
        try {  
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());  
        } finally {  
            super.afterInvocation(token, null);  
        }  
    } 

	public void init(FilterConfig arg0) throws ServletException {
	}
	
	public void destroy() {
	}
}
