package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.LeaveDetails;
import com.student.model.StudentFees;
import com.student.repository.FeesRepository;
import com.student.service.FeesService;
import com.student.service.LeaveService;


@CrossOrigin(origins ="http://localhost:3000/" )
@RestController
@RequestMapping("/api")
public class LeaveController {
	@Autowired
	LeaveService leaveservice;
	@Autowired
	FeesService feesservice;

	public LeaveController(LeaveService leaveservice, FeesService feesservice) {
		super();
		this.leaveservice = leaveservice;
		this.feesservice = feesservice;
	}

	@PostMapping("/addleave")
	public ResponseEntity<?> addUser(@RequestBody LeaveDetails leavedetails) {
		return new ResponseEntity<>(leaveservice.addLeave(leavedetails), HttpStatus.CREATED);

	}

	@PutMapping("/payfees")
	public ResponseEntity<StudentFees> updateStudent(@RequestBody StudentFees student){

		return new ResponseEntity<StudentFees>(feesservice.updateStudent(student), HttpStatus.OK);
	}
	
	@GetMapping("/Studentfees/{student_email}")
	public boolean getStudentBySId(@PathVariable("student_email") String student_email){
		return feesservice.getFeesBySId(student_email);
	}
}
