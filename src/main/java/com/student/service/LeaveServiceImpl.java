package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.student.model.LeaveDetails;
import com.student.repository.LeaveRepository;

@Service
public class LeaveServiceImpl implements LeaveService {
	private LeaveRepository leaveRepository;


	public LeaveServiceImpl(LeaveRepository leaveRepository) {
		super();
		this.leaveRepository = leaveRepository;
	}

	@Override
	public LeaveDetails addLeave(LeaveDetails leavedet) {

		return leaveRepository.save(leavedet);
	}

//	@Override
//	public List<LeaveDetails> leaveresult(String student_email) {
//		return leaveRepository.leaveresult(student_email);
//
//	}

	//	@Override
	//	public String updateLeave(String student_email, String fromdate) {
	//		LeaveDetails leave = LeaveRepository.findByStudentIdAndFromdate(student_email, fromdate);
	//		return "Leave has been added, user name = " + leave.getStudent_email();
	//
	//	}

}
