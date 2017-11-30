package com.brasajava.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails{
	private static final long serialVersionUID = 5071543417957713295L;
			
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userId;
	private String username;
	private String password;
	private String email;
	@OneToMany(fetch=FetchType.EAGER, cascade= CascadeType.ALL)
	private Collection<Role> roles;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public Collection<Role> getAuthorities() {
		return this.roles;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
