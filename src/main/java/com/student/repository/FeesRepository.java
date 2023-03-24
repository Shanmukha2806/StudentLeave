package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.student.model.StudentFees;


public interface FeesRepository extends JpaRepository<StudentFees, String>{

	@Query(value="select fees from school.student where student_email= ?;",nativeQuery=true)
	public String getFeesBySId(String student_email);
}
