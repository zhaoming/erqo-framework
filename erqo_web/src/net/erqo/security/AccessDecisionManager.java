package net.erqo.security;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

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
public class AccessDecisionManager implements
		org.springframework.security.access.AccessDecisionManager {

	protected final Log logger = LogFactory.getLog(getClass());

	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {

		if (configAttributes == null) {
			logger.debug("not resource：");
			throw new AccessDeniedException("not resource");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("request url is：" + object.toString());
		}
		
		Iterator<ConfigAttribute> ite = configAttributes.iterator();
		while (ite.hasNext()) {
			
			ConfigAttribute ca = ite.next();
			logger.debug("needRole is:" + ca.getAttribute());
			
			String needRole = ((SecurityConfig) ca).getAttribute();
			
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				logger.debug("GrantedAuthority is :" + ga.getAuthority());
				if (needRole.equals(ga.getAuthority())) { // ga is user's role.
					if (logger.isDebugEnabled()) {
						logger.debug("needRole is " + needRole + ", user role is:" + ga.getAuthority() + ",authority success !"); 
					}
					return;
				}
			}
		}
		throw new AccessDeniedException("没有权限");
	}

	@Override
	public boolean supports(ConfigAttribute arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
