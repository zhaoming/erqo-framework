package net.erqo.model;

import java.io.Serializable;

public class Erqo_users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2185718782979328313L;
	
	private Integer id;
	
	private String login_name;
	
	private String password;
	
	private Integer enable;
	
	private Erqo_roles role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String loginName) {
		login_name = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public Erqo_roles getRole() {
		return role;
	}

	public void setRole(Erqo_roles role) {
		this.role = role;
	}
	
	
	
	

}
