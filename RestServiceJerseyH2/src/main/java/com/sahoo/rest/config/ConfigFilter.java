package com.sahoo.rest.config;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import com.sahoo.rest.auth.AuthenticationService;
import com.sahoo.rest.auth.CustomSecurityContext;
import com.sahoo.rest.auth.User;

@Provider
public class ConfigFilter implements ContainerRequestFilter {

	public static final String AUTHENTICATION_HEADER = "Authorization";


	@Inject
	AuthenticationService authenticationService;
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		//SecurityContext securityContext = requestContext.getSecurityContext();
		//securityContext.getAuthenticationScheme().equals(BASIC_AUTH);
		if(authenticationService.authenticate(requestContext.getHeaderString(AUTHENTICATION_HEADER)))
			System.out.println("Successs authentication");
		else
		{
			System.out.println("Failure authentication");
		
		            throw new WebApplicationException(Status.UNAUTHORIZED);
		  
		}
		User user = authenticationService.getUserName(requestContext.getHeaderString(AUTHENTICATION_HEADER));
		String scheme = requestContext.getUriInfo().getRequestUri().getScheme();
		requestContext.setSecurityContext(new CustomSecurityContext(user, scheme));
		
	}

	

}
