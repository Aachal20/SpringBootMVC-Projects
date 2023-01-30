package in.aachal.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.aachal.model.Student;

@Controller
public class StudentOpearationsController {

	@GetMapping("/")
	public String showHomePage() {
		//return LVN -(Homepage-welcome.jsp)
		return "welcome";
	}
	
	
	@GetMapping("/register")
	public String showStudentFormPage() {
		//return LVN (form page-student_register.jsp)
		return  "student_register";
		
	}
	
	@PostMapping("/register")
	public String registerStudent(Map<String,Object> map, @ModelAttribute("stud") Student st) {
	//public String registerStudent(Map<String,Object> map, @ModelAttribute Student st) {
		System.out.println(st);
		//return LVN 
		return  "show_result";
		
	}
}
