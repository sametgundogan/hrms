package javacamp.hrms.core.abstracts;

public interface JobSeekerCheckService {
	
	boolean ifRealPerson(String tcId, String name, String lastName, int birthYear);

}
