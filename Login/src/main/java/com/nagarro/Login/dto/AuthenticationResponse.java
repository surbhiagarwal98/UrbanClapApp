package com.nagarro.Login.dto;

/**
 * 
 * @author surbhiagarwal
 * 
 * autentication response DTO
 */
public class AuthenticationResponse {

	private final String jwt;
	
	public AuthenticationResponse(String jwt) {
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

}