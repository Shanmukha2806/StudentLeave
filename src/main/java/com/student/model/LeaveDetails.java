package com.student.model;


import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="leave_management")
public class LeaveDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long leaver_id;
	
	@Column(name = "description")
	String description;

	@Column(name = "fromdate")
	String fromdate;
	
	@Column(name = "todate")
	String todate;
	
	@Column(name = "student_email")
	String student_email;
	
	@Column(name = "teacher_email")
	String teacher_email;

	public LeaveDetails() {
		super();
	}

	public LeaveDetails(long leaver_id, String description, String fromdate, String todate, String student_email,
			String teacher_email) {
		super();
		this.leaver_id = leaver_id;
		this.description = description;
		this.fromdate = fromdate;
		this.todate = todate;
		this.student_email = student_email;
		this.teacher_email = teacher_email;
	}

	public long getLeaver_id() {
		return leaver_id;
	}

	public void setLeaver_id(long leaver_id) {
		this.leaver_id = leaver_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public String getStudent_email() {
		return student_email;
	}

	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}

	public String getTeacher_email() {
		return teacher_email;
	}

	public void setTeacher_email(String teacher_email) {
		this.teacher_email = teacher_email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, fromdate, leaver_id, student_email, teacher_email, todate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LeaveDetails other = (LeaveDetails) obj;
		return Objects.equals(description, other.description) && Objects.equals(fromdate, other.fromdate)
				&& leaver_id == other.leaver_id && Objects.equals(student_email, other.student_email)
				&& Objects.equals(teacher_email, other.teacher_email) && Objects.equals(todate, other.todate);
	}

}