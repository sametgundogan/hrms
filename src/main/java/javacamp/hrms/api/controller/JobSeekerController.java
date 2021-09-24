package javacamp.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.JobSeekerService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobSeeker")
public class JobSeekerController {
	
	JobSeekerService jobSeekerService;
	
	@Autowired
	public JobSeekerController(JobSeekerService jobSeekerService) {
		this.jobSeekerService = jobSeekerService;
		
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobSeeker>> getAll(){
		return this.jobSeekerService.getAll();
	}
	@PostMapping(value = "/addNew")
	public ResponseEntity<?> addJobSeeker(@RequestBody JobSeeker jobSeeker){
		return ResponseEntity.ok(this.jobSeekerService.addJobSeeker(jobSeeker));
	}
}
