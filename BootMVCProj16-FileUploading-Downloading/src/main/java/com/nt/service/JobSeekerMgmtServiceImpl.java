package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSeekerInfo;
import com.nt.repository.IJoobSeekerRepo;

@Service
public class JobSeekerMgmtServiceImpl implements IJobSeekerMgmtService {

	@Autowired
	private IJoobSeekerRepo jsRepo;
	
	@Override
	public String registerJobSeeker(JobSeekerInfo info) {
		return "Job Seeker is saved with the  " +jsRepo.save(info).getJsId()+"Id value" ;
	}

	@Override
	public List<JobSeekerInfo> fetchAllJobSeekers() {
		//use repo
		List<JobSeekerInfo> list = jsRepo.findAll();
		return list;
	}

	@Override
	public String fetchResumePathBYJsId(Integer jsId) {
		//use repo
		return jsRepo.getResumePathByJsId(jsId);
	}

	@Override
	public String fetchPhotoPathBYJsId(Integer jsId) {
		//use repo
		return jsRepo.getPhotoPathByJsId(jsId);
	}

}
