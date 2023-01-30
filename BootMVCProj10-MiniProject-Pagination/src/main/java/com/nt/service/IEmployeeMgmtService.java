package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {

	public List<Employee> getAllEmployees();
	public Page<Employee> getEmployeePageData(Pageable pageable);
	public String registerEmployee(Employee emp);
	public Employee getEmpByno(int no);
	public String editEmployee(Employee emp);
	public String deleteEmpById(int no);
	
}
