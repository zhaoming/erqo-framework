package net.erqo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.erqo.model.Erqo_resource;
import net.erqo.model.Erqo_roles;
import net.erqo.sessionfacade.ErqoResourcesFacade;
import net.erqo.sessionfacade.ErqoRolesFacade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;

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
public class DynamicInvocationSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	private ErqoRolesFacade erqoRolesFacade;
	
	private ErqoResourcesFacade erqoResourcesFacade;
	
	private UrlMatcher urlMatcher = new AntUrlPathMatcher();  
    
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;  
    
	public void loadResourceDefine() throws Exception {

		this.resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

		// 通过数据库中的信息设置，resouce和role
		for (Erqo_roles item : this.erqoRolesFacade.getAll()) {
			Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
			ConfigAttribute ca = new SecurityConfig(item.getRole_name());
			atts.add(ca);
			List<Erqo_resource> itemList = erqoResourcesFacade.getResourceByRoleId(item.getId());
			for (Erqo_resource resources : itemList) {
				// 把资源放入到spring security的resouceMap中
				logger.debug("All ROLES : [" + item.getRole_name() + "] \t Resources: "
						+ resources.getResource_value());
				this.resourceMap.put(resources.getResource_value(), atts);
			}
		}

		// 通过硬编码设置，resouce和role
		// resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		// Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
		// ConfigAttribute ca = new SecurityConfig("admin");
		// atts.add(ca);
		// resourceMap.put("/jsp/admin.jsp", atts);
		// resourceMap.put("/swf/zara.html", atts);
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();
		for (Map.Entry<String, Collection<ConfigAttribute>> entry : resourceMap
				.entrySet()) {
			for (ConfigAttribute attrs : entry.getValue()) {
				allAttributes.add(attrs);
			}
		}
		return allAttributes;
	}
  

    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {  
 
        // guess object is a URL.  
        String url = ((FilterInvocation) object).getRequestUrl();  
        
        if (logger.isDebugEnabled()) {  
            logger.debug("this url =" + url); //$NON-NLS-1$  
        }
        Iterator<String> ite = resourceMap.keySet().iterator();  
        while (ite.hasNext()) {  
            String resURL = ite.next();  
            System.out.println("resource ="+ resURL);
            if (urlMatcher.pathMatchesUrl(resURL, url)) {  
                Collection<ConfigAttribute> returnCollection = resourceMap.get(resURL);  
                if (logger.isDebugEnabled()) {  
                    logger.debug("Match url = "+ url); //$NON-NLS-1$  
                }  
                return returnCollection;  
            }  
        }  
        if (logger.isDebugEnabled()) {  
            logger.debug("not Match url"); //$NON-NLS-1$  
        }  
        return null;  
    }  

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	public ErqoRolesFacade getErqoRolesFacade() {
		return erqoRolesFacade;
	}

	public void setErqoRolesFacade(ErqoRolesFacade erqoRolesFacade) {
		this.erqoRolesFacade = erqoRolesFacade;
	}

	public ErqoResourcesFacade getErqoResourcesFacade() {
		return erqoResourcesFacade;
	}

	public void setErqoResourcesFacade(ErqoResourcesFacade erqoResourcesFacade) {
		this.erqoResourcesFacade = erqoResourcesFacade;
	}

}
