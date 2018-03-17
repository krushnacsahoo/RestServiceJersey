package com.sahoo.rest.endpoint;

import java.security.Principal;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import com.sahoo.rest.model.Student;
import com.sahoo.rest.model.StudentList;
import com.sahoo.rest.model.StudentResponse;
import com.sahoo.rest.service.StudentServiceApi;

//@Component
//public class StudentControlApiImpl implements StudentControlApi {
@Path("/")
public class StudentEndPointApi  {

	@Inject
	StudentServiceApi studentServiceApi;


	@Context  UriInfo uriInfo;
	@Context SecurityContext securityContext;
	@GET
	@Path("all")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response displayAll() {
	
		Principal user = securityContext.getUserPrincipal();
		if(! user.getName().equals("admin"))
			throw new WebApplicationException("Not authorised", Status.UNAUTHORIZED);
		StudentList students = studentServiceApi.displayAll(uriInfo);
		//studentResponse.setStudent(students);
		return Response.ok().entity(students).build();

	}

	@POST
	@Path("student")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateStudent(Student student) {
		System.out.println(studentServiceApi.toString());
		studentServiceApi.updateStudent(student);
	}
	
	@GET
	@Path("/student/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response displayStudent(@PathParam("id") Long id) {

		StudentResponse students = studentServiceApi.getStudentByID(id, uriInfo);
		return Response.ok().entity(students).build();

	}
}
