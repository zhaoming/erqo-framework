package net.erqo.model;

import java.io.Serializable;
import java.util.List;

public class Erqo_resource  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 443691389537179484L;
	
	

	private Integer id;
	
	private Integer type;
	
	private String resource_name;
	
	private String resource_value;
	
	private List<Erqo_roles> roles;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getResource_name() {
		return resource_name;
	}

	public void setResource_name(String resourceName) {
		resource_name = resourceName;
	}

	public String getResource_value() {
		return resource_value;
	}

	public void setResource_value(String resourceValue) {
		resource_value = resourceValue;
	}

	public void setRoles(List<Erqo_roles> roles) {
		this.roles = roles;
	}

	public List<Erqo_roles> getRoles() {
		return roles;
	}
	
}
