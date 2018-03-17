package com.sahoo.rest.model;

import java.util.List;

import javax.ws.rs.core.Link;

public class StudentList {

	private List<Student> students;
	private Link link;
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Link getLink() {
		return link;
	}
	public void setLink(Link link) {
		this.link = link;
	}
	
}
