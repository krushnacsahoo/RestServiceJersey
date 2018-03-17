package com.sahoo.rest.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.UriInfo;

import org.springframework.stereotype.Component;

import com.sahoo.rest.model.Student;
import com.sahoo.rest.model.StudentList;
import com.sahoo.rest.model.StudentResponse;
import com.sahoo.rest.repository.StudentRepository;

@Component
public class StudentServiceImpl implements StudentServiceApi {

	@Inject
	StudentRepository studentRepository;

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.test.demorest2.service.StudentServiceApi#displayAll()
	 */
	@Override
	public StudentList displayAll(UriInfo uriInfo) {

		List<Student> findAll = studentRepository.findAll();
		
		
		StudentList studentList =  new StudentList();
		studentList.setStudents(findAll);
		
		
		Link link = Link.fromUri(uriInfo.getBaseUri() + uriInfo.getPath()).rel("self").build();
		System.out.println(link.toString());
		studentList.setLink(link);
		
		return studentList;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.test.demorest2.service.StudentServiceApi#updateStudent(com.
	 * example.test.demorest2.model.Student)
	 */
	@Override
	public void updateStudent(Student student) {
		System.out.println(studentRepository.toString());
		studentRepository.save(student);
	}
	
	public StudentResponse getStudentByID(Long studentId, UriInfo uriInfo) {
		
		Student student = (Student)studentRepository.findOne(studentId);
		StudentResponse studentResponse =  new StudentResponse();
		studentResponse.setStudent(student);
		
		
		Link link = Link.fromUri(uriInfo.getBaseUri() + uriInfo.getPath()).rel("self").build();
		System.out.println(link.toString());
		studentResponse.setLink(link);
		
		return studentResponse;
			
	}
}