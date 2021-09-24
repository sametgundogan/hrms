package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.JobPositionService;
import javacamp.hrms.core.concretes.JobTitleCheckList;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.ErrorResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.core.utilities.SuccessDataResult;
import javacamp.hrms.core.utilities.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.JobPositionDao;
import javacamp.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	
	JobPositionDao jobPositionDao;
	
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
		
	}
	@Override
	public Result addJobPosition(JobPosition jobPosition) {
		boolean isContainJob = JobTitleCheckList.checkListIn(jobPositionDao.findAll(), jobPosition.getTitle());
		
		if (isContainJob) {
			return new ErrorResult("Bu pozisyon zaten var!");
			
		}
		jobPositionDao.save(jobPosition);
		
		return new SuccessResult("Pozisyon ekleme başarılı.");
		
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<>(jobPositionDao.findAll(),"İş pozisyonları listelendi.");
	}
	

}
