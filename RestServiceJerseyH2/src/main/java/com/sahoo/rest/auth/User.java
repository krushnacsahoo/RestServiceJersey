package com.sahoo.rest.auth;

import java.security.Principal;

public class User implements Principal {

	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
