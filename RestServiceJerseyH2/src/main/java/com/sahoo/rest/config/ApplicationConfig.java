package com.sahoo.rest.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/rest/v1")
public class ApplicationConfig extends ResourceConfig{

	public ApplicationConfig() {
		//register(StudentControlApi.class);
		packages("com.sahoo.rest");
	}

}
