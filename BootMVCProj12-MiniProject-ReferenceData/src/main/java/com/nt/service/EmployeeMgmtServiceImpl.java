package com.nt.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

	@Override
	public Set<String> getAllCountries() {
		//get All locales of the world
		Locale[] locale = Locale.getAvailableLocales();
		Set<String> countrySet = new TreeSet();
		for(Locale l : locale) {
			if(l!=null) {
				countrySet.add(l.getDisplayCountry());
			}
			
		}
		return countrySet;
	}

	@Autowired
	private Environment env;
	
	@Override
	public List<String> getStatesByCountry(String country) {
		//get states of a country through env object
		String statesInfo = env.getRequiredProperty("country");
		//convert comma seperated values into List collection using "," delimeter
		List<String> statesList = Arrays.asList(statesInfo.split(","));
				//sort collection(natural sorting)
		Collections.sort(statesList);
		return statesList;
		
	}

	
}
