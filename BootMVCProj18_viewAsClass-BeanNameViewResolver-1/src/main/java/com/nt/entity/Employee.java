package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Entity
@Table(name = "emp_ii")
public class Employee implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer empno;
	private String ename;
	private String job;
	private Float sal;
}
