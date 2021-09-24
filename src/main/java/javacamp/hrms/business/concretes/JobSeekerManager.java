package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.JobSeekerService;
import javacamp.hrms.business.abstracts.UserService;
import javacamp.hrms.core.concretes.CheckRegisterRullers;
import javacamp.hrms.core.concretes.JobSeekerCheckManager;
import javacamp.hrms.core.concretes.MernisServiceAdapter;
import javacamp.hrms.core.entities.MailValidation;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.ErrorResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.core.utilities.SuccessDataResult;
import javacamp.hrms.core.utilities.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.JobSeekerDao;
import javacamp.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{

	UserService userService;
	
	JobSeekerDao jobSeekerDao;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, UserService userService) {
		this.jobSeekerDao = jobSeekerDao;
		this.userService = userService;
	}
	
	
	@Override
	public Result addJobSeeker(JobSeeker jobSeeker) {

		CheckRegisterRullers checkRegisterRullers = new CheckRegisterRullers();
		checkRegisterRullers.setUserList(userService.getAll());
		checkRegisterRullers.setJobSeekerList(jobSeekerDao.findAll());
		
		boolean isContainsMail = checkRegisterRullers.checkUserMail(jobSeeker.getMail());
		boolean isContainsTcId = checkRegisterRullers.checkJobSeekerTcId(jobSeeker.getTcId());
		
		JobSeekerCheckManager jobSeekerCheckManager = new JobSeekerCheckManager(new MernisServiceAdapter());
		
		boolean checkUser = jobSeekerCheckManager.ifRealPerson(jobSeeker.getTcId(), jobSeeker.getName(), jobSeeker.getLastName(), jobSeeker.getBirthYear());
		
		if (isContainsMail || isContainsTcId || !checkUser) {
			System.out.println("Bu bilgiler başka bir kullanıcıya ait. Lütfen bilgilerinizi kontrol ediniz.");
			return new ErrorResult("Kayıt gerçekleştirilemedi. Bilgilerinizi kontrol ediniz.");
		}
		
		jobSeeker.setMailValidation(new MailValidation());
		jobSeekerDao.save(jobSeeker);
		
		return new SuccessResult("Kayıt gerçekleştirildi. Teşekkürler...");
		
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {		// TODO Auto-generated method stub
		return new SuccessDataResult<>(jobSeekerDao.findAll(), "İş arayan kullanıcılar listelendi.");
	}

	
}
