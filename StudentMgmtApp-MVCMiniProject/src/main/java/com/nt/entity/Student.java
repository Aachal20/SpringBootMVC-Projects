package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



import lombok.Data;

@Data
@Entity
@Table(name="STUDENT_MASTER")
public class Student implements Serializable{

	@javax.persistence.Id
	@SequenceGenerator(name="gen2" , sequenceName = "stud_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="SID")
	private Integer sid;
	
	@Column(name="FIRST_NAME" ,length=20)
	private String fname;
	
	@Column(name="LAST_NAME" , length=20)
	private String lname;
	
	@Column(name="ADDRESS" , length=20)
	private String addrs;
	
	@Column(name="COURSE_NAME")
	private String course;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="MOB_NUMBER")
	private Long phno;
	
}
