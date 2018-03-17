package com.sahoo.rest.model;

import javax.ws.rs.core.Link;

import org.springframework.stereotype.Component;

@Component
public class StudentResponse {

	private Student student;
	private Link link;
	
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Link getLink() {
		return link;
	}
	public void setLink(Link link) {
		this.link = link;
	}
	
}
