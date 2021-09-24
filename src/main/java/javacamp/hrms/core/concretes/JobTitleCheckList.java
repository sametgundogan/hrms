package javacamp.hrms.core.concretes;

import java.util.List;

import javacamp.hrms.entities.concretes.JobPosition;

public class JobTitleCheckList {
	
	public static boolean checkListIn(List<JobPosition> list, String checkValue) {
		for (JobPosition jobPosition : list) {
			if (jobPosition.getTitle().equalsIgnoreCase(checkValue)) {
				System.out.println("Bu pozisyon sistemde kayıtlıdır.");
				return true;
			}
		}
	return false;
	}
	

}
