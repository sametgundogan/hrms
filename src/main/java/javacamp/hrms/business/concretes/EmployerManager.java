package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import javacamp.hrms.business.abstracts.EmployerService;
import javacamp.hrms.business.abstracts.UserService;
import javacamp.hrms.core.concretes.CheckRegisterRullers;
import javacamp.hrms.core.entities.MailValidation;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.ErrorResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.core.utilities.SuccessDataResult;
import javacamp.hrms.core.utilities.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.EmployerDao;
import javacamp.hrms.entities.concretes.Employer;
import javacamp.hrms.entities.concretes.HrmsValidation;

public class EmployerManager implements EmployerService{

	EmployerDao employerDao;
	
	UserService userService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, UserService userService) {
		this.employerDao = employerDao;
		this.userService = userService;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<>(employerDao.findAll(),"Şirketler listelendi.");
	}

	@Override
	public Result addEmployer(Employer employer) {
		CheckRegisterRullers checkRegisterRullers = new CheckRegisterRullers();
		checkRegisterRullers.setUserList(userService.getAll());
		
		boolean isContainsMail = checkRegisterRullers.checkUserMail(employer.getMail());
		
		if(isContainsMail) {
			System.out.println("Bu mail daha önceden alınmış. Şifrenizi unuttuysanız 'şifremi unuttum' butonuna tıklayınız.");
			return new ErrorResult("Kayıt gerçekleşmedi. Lütfeni bilgilerinizi doğru girdiğinizden emin olunuz.");
			}
		MailValidation mailValidation = new MailValidation();
		mailValidation.setUser(employer);
		employer.setMailValidation(mailValidation);
		
		HrmsValidation hrmsValidation = new HrmsValidation();
		hrmsValidation.setEmployer(employer);
		employer.setHrmsValidation(hrmsValidation);
		
		employerDao.save(employer);
		
		return new SuccessResult("Kayıtl işlemi başarılı!");
	}

}
