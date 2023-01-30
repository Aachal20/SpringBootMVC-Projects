package com.nt.service;

import java.util.List;

import com.nt.entity.Student;

public interface IStudentServiceMgmt {

	public String registerStudent(Student stud);
	public List<Student> getAllStudent();
	//public Student getStudent(Integer sId);
	//public String deleteStudent(Integer sId);
	
}
