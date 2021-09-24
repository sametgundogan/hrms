package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	Result addJobPosition(JobPosition jobPosition);
	
	DataResult<List<JobPosition>> getAll();

}
