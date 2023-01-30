package com.nt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.EmployeeMgmtServiceImpl;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Controller
public class EmployeeOPerationsController {

	@Autowired
	private EmployeeMgmtServiceImpl service;

	@GetMapping("/")
	public String showHome() {
		return "home";
	}


	@GetMapping("/report1")
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
		emp.setJob("CLERK");  //INTIAL VALUE TO DISAPLY IN FORM COMPONENT


		//return lvn
		return "employee_register";

	}//method

	@PostMapping("/add")
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
	}

	/*
		@PostMapping("/add")
		public String addEmployee(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp) {
			System.out.println("EmployeeOPerationsController.showEditEmployeeForm()");
			//use service
			String result = service.registerEmployee(emp);
			List<Employee> list = service.getAllEmployees();
			//keep results in model attribute(Redirct)
			attrs.addFlashAttribute("resultMsg", result);
			//map.put("empsData", list);
			 * System.out.println("EmployeeOPerationsController.showEditEmployeeForm()");
			//return LVN
			return "redirect:report1";
		}*/


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
	public String showEditEmployeeFormm(@ModelAttribute("emp") Employee emp,Map<String,Object> map) {
		//use service
		String result = service.editEmployee(emp);
		List<Employee> list = service.getAllEmployees();
		//keep results in model attribute
		map.put("resultMsg", result);
		map.put("empsData", list);
		//return LVN
		return "employee_report";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("no") int no, Map<String,Object> map) {
		//use service
		String result = service.deleteEmpById(no);
		List<Employee> list = service.getAllEmployees();
		//keep results in model attribute
		map.put("resultMsg", result);
		map.put("empsData", list);
		//return LVN
		return "employee_report";
	}
}
