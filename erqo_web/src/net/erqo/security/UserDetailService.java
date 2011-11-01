package net.erqo.security;

import java.util.ArrayList;
import java.util.List;

import net.erqo.model.Erqo_users;
import net.erqo.sessionfacade.ErqoUsersFacade;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

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
public class UserDetailService implements UserDetailsService {

	private ErqoUsersFacade erqoUsersFacade;
	
	public ErqoUsersFacade getErqoUsersFacade() {
		return erqoUsersFacade;
	}

	public void setErqoUsersFacade(ErqoUsersFacade erqoUsersFacade) {
		this.erqoUsersFacade = erqoUsersFacade;
	}

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		Erqo_users user = erqoUsersFacade.getUserByName(username);
		if (user != null) {
			return getUserDetails(user);
		} else {
			throw new UsernameNotFoundException("User does not exists");
		}
	}
	
	public UserDetails getUserDetails(Erqo_users user) {
		
        GrantedAuthorityImpl g = new GrantedAuthorityImpl(user.getRole().getRole_name());
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        list.add(g);
        boolean enable = false;
        if(user.getEnable() == 1){
        	enable = true;
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin_name(), user.getPassword(),
        		enable, true, true, true, list);
    }

}
