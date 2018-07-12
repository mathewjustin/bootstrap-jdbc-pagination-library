package com.jdbc.entities;

import java.util.Date;

import com.jdbc.custom.annotations.ColumnName;
import com.jdbc.custom.annotations.EntityProperties;

//This entity maps the student table
/**
 * @author jumathew
 *
 */
/**
 * @author jumathew
 *
 */
@EntityProperties(value="Student_tbl")
public class Student {

	
	public Student() {
		super();
	}

	public Student(Integer studentId, String studentName, String studentDept, String studentDeptLoc, Date createdOn,
			String createdBy) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentDept = studentDept;
		this.studentDeptLoc = studentDeptLoc;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentDept() {
		return studentDept;
	}

	public void setStudentDept(String studentDept) {
		this.studentDept = studentDept;
	}

	public String getStudentDeptLoc() {
		return studentDeptLoc;
	}

	public void setStudentDeptLoc(String studentDeptLoc) {
		this.studentDeptLoc = studentDeptLoc;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@ColumnName(value="student_id",rowPosition="0")
	private Integer studentId;
	
	@ColumnName(value="student_name",rowPosition="1")
	private String studentName;
	
	@ColumnName(value="student_dept",rowPosition="2")
	private String studentDept;

	@ColumnName(value="student_dept_loc",rowPosition="3")
	private String studentDeptLoc;

	@ColumnName(value="created_on",rowPosition="4")
	private Date createdOn;

	@ColumnName(value="created_by",rowPosition="5")
	private String createdBy;
	
}


 


