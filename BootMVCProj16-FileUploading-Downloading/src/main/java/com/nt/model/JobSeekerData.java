package com.nt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;


@Data
public class JobSeekerData implements Serializable {


	private Integer jsId;
	private String jsName;
	private String jsAddrs;
	private MultipartFile  resume;  //Input stream to hold content of uploaded file
	private MultipartFile  photo;
}
