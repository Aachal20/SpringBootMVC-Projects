package com.nt.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nt.entity.JobSeekerInfo;
import com.nt.model.JobSeekerData;
import com.nt.service.IJobSeekerMgmtService;


@Controller
public class JobSeekerOperationsController {

	

	@Autowired
	private IJobSeekerMgmtService service;

	@GetMapping("/")
	public String showHomePage() {
		return "welcome";
	}

	@GetMapping("/register")
	public String showjsRegistrationForm(@ModelAttribute("js") JobSeekerData data) {
		//return lvn
		return "jobseeker_register";
	}

	@Autowired
	private Environment env;
	
	@PostMapping("/register")
	public String registerJsByUploadingFiles(@ModelAttribute("js")JobSeekerData data,
			Map<String,Object> map) throws Exception {
		//get Upload foder location from properties file
		String storeLocation = env.getRequiredProperty("upload.store");
		//if that not avilable create it
		File file = new File(storeLocation);
		if(!file.exists())
			file.mkdir();
		//get inputStream representing the upload file content
		MultipartFile resumeFile = data.getResume();
		MultipartFile photoFile = data.getPhoto();
		InputStream isResume = resumeFile.getInputStream();
		InputStream isPhoto = photoFile.getInputStream();
		//get the names of uploaded file
		String resumeFileName = resumeFile.getOriginalFilename();
		String photoFileName = photoFile.getOriginalFilename();
		//create outputStream representing empty destination files
		OutputStream osResume = new FileOutputStream(file.getAbsolutePath()+ "\\"+resumeFileName);
		OutputStream osPhoto = new FileOutputStream(file.getAbsolutePath()+ "\\"+photoFileName);
		//perform file copy operation
		IOUtils.copy(isPhoto, osPhoto);
		IOUtils.copy(isResume, osResume);
		//close stream
		isPhoto.close();
		isResume.close();
		osPhoto.close();
		osResume.close();
		//prepare entity class obj from model class obj
		JobSeekerInfo info = new JobSeekerInfo();
		info.setJsName(data.getJsName());
		info.setJsAddrs(data.getJsAddrs());
		info.setPhotoPath(file.getAbsolutePath()+ "\\"+resumeFileName);
		info.setResumePath(file.getAbsolutePath()+ "\\"+photoFileName);

		//use service
		String msg = service.registerJobSeeker(info);
		//keep the uploaded filenames and location in model attributes
		map.put("file1" , resumeFileName);
		map.put("file2",photoFileName);
		map.put("resultMsg", msg);

		return "show_result";
	}
	
	@GetMapping("/list_js")
	public String showReport(Map<String,Object> map) {
		System.out.println("JobSeekerOperationsController.showReport()");
		//use service
		List<JobSeekerInfo> allJobSeekers = service.fetchAllJobSeekers();
		System.out.println("Record Size ::(count)" +allJobSeekers.size());
		//add result to model attribute
		map.put("jsList", allJobSeekers);
		//return LVN
		return "show_report";
	}

	@Autowired
private ServletContext sc;
	
/*//downloading a file   here photo directly display on browser window
@GetMapping("/download")
public String downloadFile(HttpServletResponse res , @RequestParam("jsId")Integer id,@RequestParam("type")String path) throws Exception {
	//get Path of the file to be download
	String filePath=null;
	if(path.equalsIgnoreCase("resume")) 
		 filePath = service.fetchResumePathBYJsId(id);
	else
		 filePath = service.fetchPhotoPathBYJsId(id);
	System.out.println("Path of the file that to be downloaded:: " +filePath);
	//create a file object representing file to be downloded
	File file = new File(filePath);
	//get the length of the file and make it as a response conetent type
	long length = file.length();
	res.setContentLengthLong(length);
	//get MIME type of the file and make it as a response content type 
	String mimeType = sc.getMimeType(filePath);
	mimeType=mimeType==null?"application/octet-stream":mimeType;
	res.setContentType(mimeType);
	//create InputStream pointing to file
	InputStream is = new FileInputStream(file);
	//create output stream pointing to response obj
	ServletOutputStream os = res.getOutputStream();
	//instruct the browser to give file content as downloadable file
	res.setHeader("Content-Disposition:" ,"attachement;fileName"+file.getName());
	//write file content to response object
	IOUtils.copy(is, os);
	//close stream
	is.close();
	os.close();
	return null; //make the handler  method to send response directly to browser
}*/
	
	//the conetent will be download here
	@GetMapping("/download")
	public String fileDownload(HttpServletResponse res, @RequestParam("jsId") Integer id, @RequestParam("type") String type) throws IOException {
		//get path of the file to be downloaded
		String filePath = null;
		if(type.equalsIgnoreCase("resume"))
			filePath = service.fetchResumePathBYJsId(id);
		else
			filePath = service.fetchPhotoPathBYJsId(id);
		System.out.println(filePath);
		//Create file object representing file to be downloaded
		File file = new File(filePath);
		//get the length of the file and make it as the response content length
		res.setContentLengthLong(file.length());
		//get MIME type of the file and make it as the response content type
		String mimeType = sc.getMimeType(filePath);
		mimeType=mimeType==null?"application/octet-stream":mimeType;
		res.setContentType(mimeType);
		//create InputStream pointing to the file
		InputStream is = new FileInputStream(file);
		//create OutputStream pointing to the response object
		OutputStream os = res.getOutputStream();
		//Instruct the browser to give file content as downloadable file
		res.setHeader("Content-Disposition","attachment;fileName="+file.getName());
		//Write file content to response object
		IOUtils.copy(is, os);
		//close streams
		is.close();
		os.close();
		return null;  //makes the handler method to send response directly to browser
	}
}












