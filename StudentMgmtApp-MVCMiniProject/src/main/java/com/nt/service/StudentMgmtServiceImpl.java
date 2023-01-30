package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Student;
import com.nt.repository.StudentRepository;

@Service
public class StudentMgmtServiceImpl implements IStudentServiceMgmt {

	@Autowired
	private StudentRepository studRepo;
	
	@Override
	public String registerStudent(Student student) {
		Integer id = studRepo.save(student).getSid();
		return "STUDENT SAVED SUCCSSFULLY" +id;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> list = studRepo.findAll();
		return list;
	}

}
