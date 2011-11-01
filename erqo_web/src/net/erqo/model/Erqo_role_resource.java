package net.erqo.model;

import java.io.Serializable;

public class Erqo_role_resource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8145592636204969636L;
	
	private Integer id;
	
	private Integer role_id;
	
	private Integer resource_id;
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setResource_id(Integer resource_id) {
		this.resource_id = resource_id;
	}

	public Integer getResource_id() {
		return resource_id;
	}
}
