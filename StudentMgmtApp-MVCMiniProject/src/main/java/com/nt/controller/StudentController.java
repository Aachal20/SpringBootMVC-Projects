package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.entity.Student;
import com.nt.service.StudentMgmtServiceImpl;

@Controller
public class StudentController {

	@Autowired
	private StudentMgmtServiceImpl service;
	
	@GetMapping("/")
	public String showHome() {
		System.out.println("StudentController.showHome()");
		return "welcome";
	}
	
	@GetMapping("/report")
	public String showStudentReport(Map<String,Object> map) {
		System.out.println("StudentController.registerStudent()");
		//use service
		List<Student> list = service.getAllStudent();
		map.put("studsData" , list);
		return "student_report";
	}
	
	

	@GetMapping("/add")
	public String showregisteredStudentForm(@ModelAttribute("stud") Student student) {
		
		return "student_register";	
		
	}
	
	@PostMapping("/add")
	public String registeredStudent(Map<String,Object> map , @ModelAttribute("stud") Student student) {
		String msg = service.registerStudent(student);
		List<Student> list = service.getAllStudent();
		map.put("studsData" , list);
		map.put("resultMsg", msg);
		return "student_report";	
		
	}
}
