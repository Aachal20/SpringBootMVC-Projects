package com.nt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.EmployeeMgmtServiceImpl;
import com.nt.validations.EmployeeValidator;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Controller
public class EmployeeOPerationsController {

	@Autowired
	private EmployeeMgmtServiceImpl service;
	
	@Autowired
	private EmployeeValidator empValidator;
	

	@GetMapping("/")
	public String showHome() {
		return "home";
	}


	@GetMapping("/report")
	public String showEmployeeReport(Map<String,Object> map) {
		//use service
		List<Employee> list = service.getAllEmployees();
		//put the result in model attribute
		map.put("empsData", list);
		//return lvn
		return "employee_report";

	}//method

	//For form launching
	@GetMapping("/add")
	public String showAddEmployeeForm(@ModelAttribute("emp")Employee emp) {
		System.out.println("EmployeeOPerationsController.showAddEmployeeForm()");
		
		emp.setJob("CLERK");  //INTIAL VALUE TO DISAPLY IN FORM COMPONENT
		//return lvn
		return "employee_register";

	}//method

	/*@PostMapping("/add")
	public String addEmployee(HttpSession ses, @ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeOPerationsController.showEditEmployeeForm()");
		//use service
		String result = service.registerEmployee(emp);
		List<Employee> list = service.getAllEmployees();
		//keep results in sesion attribute
		ses.setAttribute("resultMsg" , result);
		//map.put("empsData", list);
		System.out.println("EmployeeOPerationsController.addEmployee()");
		//return LVN
		return "redirect:report1";
	}*/


	@PostMapping("/add")
	public String addEmployee(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp , BindingResult errors) {
		System.out.println("EmployeeOPerationsController.showEditEmployeeForm()");
		
		if(errors.hasFieldErrors())
			return "employee_register";
			
			
		if(empValidator.supports(emp.getClass())) {
			empValidator.validate(emp, errors);
			if(errors.hasErrors())
				return "employee_register";
		}
		
		if(emp.getJob().equalsIgnoreCase("hacker")) {
			errors.rejectValue("job", "job.reject");
			return "employee_register";
		}
		//use service
		String result = service.registerEmployee(emp);
		List<Employee> list = service.getAllEmployees();
		//keep results in model attribute(Redirct)
		attrs.addFlashAttribute("resultMsg", result);
		//map.put("empsData", list);
		System.out.println("EmployeeOPerationsController.showEditEmployeeForm()");
		//return LVN
		return "redirect:report";
	}


	@GetMapping("/edit")
	public String showEditEmployeeForm(@RequestParam int no, @ModelAttribute("emp") Employee emp) {

		//use service
		Employee emp1 = service.getEmpByno(no);
		//emp=emp1;
		BeanUtils.copyProperties(emp1, emp);
		//return LVN
		return "employee_edit";
	}



	@PostMapping("/edit")
	public String EditEmployee(@ModelAttribute("emp") Employee emp, RedirectAttributes attrs,BindingResult errors) {
		
		//checking for type mismatch error
		if(errors.hasFieldErrors())
			return "employee_register";
		
		if(empValidator.supports(emp.getClass())) {
			empValidator.validate(emp, errors);
			if(errors.hasErrors())
				return "employee_edit";
		}
		
		//application logic error
		if(emp.getJob().equalsIgnoreCase("hacker")) {
			errors.rejectValue("job", "job.reject");
			return "employee_register";
		}
		//use service
		String result = service.editEmployee(emp);
		//keep result as a flash attributes in Redirect scope
		attrs.addFlashAttribute("resultMsg" ,result);
		//return LVN
		return "redirect:report";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("no") int no,RedirectAttributes attrs) {
		//use service
		String result = service.deleteEmpById(no);
		//keep result as a flash attributes in Redirect scope
		attrs.addFlashAttribute("resultMsg" ,result);
		//return LVN
		return "redirect:report";
	}
}//class
