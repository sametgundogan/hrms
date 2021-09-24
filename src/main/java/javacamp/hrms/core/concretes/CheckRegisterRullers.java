package javacamp.hrms.core.concretes;

import java.util.List;

import javacamp.hrms.entities.concretes.JobSeeker;
import javacamp.hrms.entities.concretes.User;
import lombok.Data;

@Data
public class CheckRegisterRullers {
	
	private List<User> userList;
	private List<JobSeeker> jobSeekerList;
	
	public boolean checkUserMail(String mail) {
		for (User user : this.userList) {
			if(user.getMail().equalsIgnoreCase(mail)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkJobSeekerTcId(String tcId) {
		for(JobSeeker jobSeeker : this.jobSeekerList) {
			if(jobSeeker.getTcId().equalsIgnoreCase(tcId)) {
				return true;
			}
		}
		return false;
	}

	public CheckRegisterRullers(List<User> userList, List<JobSeeker> jobSeekerList) {
		super();
		this.userList = userList;
		this.jobSeekerList = jobSeekerList;
	}

	public CheckRegisterRullers() {
		// TODO Auto-generated constructor stub
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<JobSeeker> getJobSeekerList() {
		return jobSeekerList;
	}

	public void setJobSeekerList(List<JobSeeker> jobSeekerList) {
		this.jobSeekerList = jobSeekerList;
	}
	
}
