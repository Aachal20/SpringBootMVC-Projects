package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.entity.Employee;
import com.nt.service.EmployeeMgmtServiceImpl;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationsController {

	@Autowired
	private IEmployeeMgmtService service;

	@GetMapping("/")
	public String showHome() {
		System.out.println("EmployeeOperationsController.showHome()");
		//return lvn
		return "aa";
	}

	@GetMapping("/report")
	public String showReport(Map<String,Object> map,@RequestParam("type") String type) {
		//use service
		List<Employee> list = service.getAllEmployee();
		//add result to model attribute
		map.put("empsList", list);
		//return lvn based on hyperlink that is clicked
		if(type.equalsIgnoreCase("excel"))
			return "excel_report";
		else
			return "pdf_report";

	}
}
