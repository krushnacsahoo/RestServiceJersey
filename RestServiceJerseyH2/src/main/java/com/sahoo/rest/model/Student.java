package com.sahoo.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@XmlRootElement
@Entity
public class Student {

	@Id
	@GeneratedValue
	private Long studentId;
	private String student_name;
	private String class_name;
	

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", student_name=" + student_name + ", class_name=" + class_name
				+ "]";
	}

	

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Long studentId, String student_name, String class_name) {
		super();
		this.studentId = studentId;
		this.student_name = student_name;
		this.class_name = class_name;
	}

	


	public Long getStudentId() {
		return studentId;
	}



	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}



	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
}
