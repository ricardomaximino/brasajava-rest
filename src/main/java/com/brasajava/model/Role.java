package com.brasajava.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String role;
	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String getAuthority() {
		return role;
	}

}
