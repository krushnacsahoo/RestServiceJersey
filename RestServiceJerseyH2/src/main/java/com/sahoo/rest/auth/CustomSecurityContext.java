package com.sahoo.rest.auth;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

public class CustomSecurityContext implements SecurityContext {

	private User user;
	private String scheme;
	
	public CustomSecurityContext(User user, String scheme) {
		super();
		this.user = user;
		this.setScheme(scheme);
	}

	@Override
	public Principal getUserPrincipal() {
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public boolean isUserInRole(String role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSecure() {
		// TODO Auto-generated method stub
		 return "https".equals(this.scheme);
	}

	@Override
	public String getAuthenticationScheme() {
		// TODO Auto-generated method stub
		return SecurityContext.BASIC_AUTH;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

}
