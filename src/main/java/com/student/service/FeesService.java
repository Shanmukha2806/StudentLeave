package com.student.service;

import com.student.model.StudentFees;

public interface FeesService {
	StudentFees getFeesById(String student_email);
	StudentFees updateStudent(StudentFees student);
	boolean getFeesBySId(String student_email);
}
