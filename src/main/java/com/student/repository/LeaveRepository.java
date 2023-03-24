package com.student.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.student.model.LeaveDetails;

public interface LeaveRepository  extends JpaRepository<LeaveDetails, String>{

//    static LeaveDetails findByStudentIdAndFromdate(String student_email,String fromdate) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Query(value = "SELECT * FROM school.leave_management WHERE student_email = ?;", nativeQuery = true)
//	List<LeaveDetails> leaveresult(String student_email);

}
