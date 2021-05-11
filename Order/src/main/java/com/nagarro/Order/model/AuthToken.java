package com.nagarro.Order.model;

import javax.persistence.Entity;

/**
 * AuthToken entity
 * 
 * @author surbhiagarwal
 *
 */
@Entity
public class AuthToken {

	private String authToken;

	public AuthToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthToken(String authToken) {
		super();
		this.authToken = authToken;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
		;
	}

}
