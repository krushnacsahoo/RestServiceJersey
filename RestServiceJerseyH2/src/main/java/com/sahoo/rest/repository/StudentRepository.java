package com.sahoo.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sahoo.rest.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
