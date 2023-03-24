package com.student.service;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.student.ExceptionHandling.ResourceNotFoundException;
import com.student.model.StudentFees;
import com.student.repository.FeesRepository;

@Service
public class FeesServiceImpl implements FeesService{
	private FeesRepository feesRepository;

	public FeesServiceImpl(FeesRepository feesRepository) {
		super();
		this.feesRepository = feesRepository;
	}

	@Override
	public StudentFees updateStudent(StudentFees student) {
		StudentFees existingStudent = feesRepository.findById(student.getStudent_email()).orElseThrow(
					() -> new ResourceNotFoundException("Student", "Id", student.getStudent_email()));;
					existingStudent.setFees(student.getFees());
					feesRepository.save(existingStudent);
					return existingStudent;
		}

	@Override
	public StudentFees getFeesById(String student_email) {
		Optional<StudentFees> student = feesRepository.findById(student_email);
		if(student.isPresent()) {
			return student.get();
		}else {
			throw new ResourceNotFoundException("Student", "Id", student_email);
		}
	}

	@Override
	public boolean getFeesBySId(String student_email) {
		if((feesRepository.getFeesBySId(student_email)).equals("0")){
			return false;
		}
		return true;
	}
}
