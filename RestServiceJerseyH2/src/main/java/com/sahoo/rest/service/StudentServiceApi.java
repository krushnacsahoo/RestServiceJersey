package com.sahoo.rest.service;

import javax.ws.rs.core.UriInfo;

import com.sahoo.rest.model.Student;
import com.sahoo.rest.model.StudentList;
import com.sahoo.rest.model.StudentResponse;

public interface StudentServiceApi {

	StudentList displayAll(UriInfo uriInfo);

	void updateStudent(Student student);
	
	StudentResponse getStudentByID(Long id, UriInfo uriInfo);

}