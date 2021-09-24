package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	
	Result addJobSeeker(JobSeeker jobSeeker);
	
	DataResult<List<JobSeeker>> getAll();
	

}
