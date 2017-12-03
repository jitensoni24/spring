package com.dtech.sauth.api.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Roles{

	private String role;

	public Roles() {}
	
	public Roles(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
