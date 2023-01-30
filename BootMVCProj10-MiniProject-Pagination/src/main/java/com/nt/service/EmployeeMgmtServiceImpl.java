package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repository.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepo empRepo;

	
	
	@Override
	public String registerEmployee(Employee emp) {
		Integer eno = empRepo.save(emp).getEmpno();
		return "Employee is saved with Id value" +eno;
	}
	
	@Override
	public Employee getEmpByno(int no) {
		Employee emp = empRepo.findById(no).get();
		return emp;
	}
	
	@Override
	public String editEmployee(Employee emp) {
		Integer empno = empRepo.save(emp).getEmpno();
		return  +empno+ ":: Employee is updated" ;
	}
	
	@Override
	public String deleteEmpById(int no) {
	empRepo.deleteById(no);
		return +no+ "emp no Employee is deleted";
	}

	@Override
	public Page<Employee> getEmployeePageData(Pageable pageable) {
	    Page<Employee> page = empRepo.findAll(pageable);
		return page;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
