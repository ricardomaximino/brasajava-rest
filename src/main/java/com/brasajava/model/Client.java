package com.brasajava.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Client implements Serializable{
	private static final long serialVersionUID = -1462399287228395229L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long clientId;
	private String name;
	private String lastname;
	private String nickname;
	@OneToOne
	private User user;
	
	public long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
