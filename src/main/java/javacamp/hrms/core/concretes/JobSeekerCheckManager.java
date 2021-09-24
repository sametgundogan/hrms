package javacamp.hrms.core.concretes;

import javacamp.hrms.core.abstracts.JobSeekerCheckService;

public class JobSeekerCheckManager implements JobSeekerCheckService {

	JobSeekerCheckService jobSeekerCheckService;
	
	public JobSeekerCheckManager(JobSeekerCheckService jobSeekerCheckService) {
		this.jobSeekerCheckService = jobSeekerCheckService;
	}
	
	@Override
	public boolean ifRealPerson(String tcId, String name, String lastName, int birthYear) {
		return jobSeekerCheckService.ifRealPerson(tcId, name, lastName, birthYear);
	}

}
