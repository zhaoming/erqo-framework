package net.erqo.model;

import java.io.Serializable;
import java.util.List;

public class Erqo_roles  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4384195587810342076L;

	private Integer id;
	
	private String role_name;
	
	private String role_desc;
	
	private List<Erqo_users> users;
	
	private List<Erqo_role_resource> resources;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String roleName) {
		role_name = roleName;
	}

	public String getRole_desc() {
		return role_desc;
	}

	public void setRole_desc(String roleDesc) {
		role_desc = roleDesc;
	}

	public void setUsers(List<Erqo_users> users) {
		this.users = users;
	}

	public List<Erqo_users> getUsers() {
		return users;
	}

	public void setResources(List<Erqo_role_resource> resources) {
		this.resources = resources;
	}

	public List<Erqo_role_resource> getResources() {
		return resources;
	}
	
	
	
}
