package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import javacamp.hrms.business.abstracts.SystemPersonelService;
import javacamp.hrms.core.concretes.CheckRegisterRullers;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.ErrorResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.core.utilities.SuccessDataResult;
import javacamp.hrms.core.utilities.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.SystemPersonelDao;
import javacamp.hrms.dataAccess.abstracts.UserDao;
import javacamp.hrms.entities.concretes.SystemPersonel;

public class SystemPersonelManager implements SystemPersonelService{

	UserDao userDao;
	SystemPersonelDao systemPersonelDao;
	
	@Autowired
	public SystemPersonelManager(SystemPersonelDao systemPersonelDao, UserDao userDao) {
		this.systemPersonelDao = systemPersonelDao;
		this.userDao = userDao;
		}
	
	@Override
	public DataResult<List<SystemPersonel>> getAll() {
		return new SuccessDataResult<>(systemPersonelDao.findAll(),"Sistem personeli listelendi.");
	}

	@Override
	public Result addSystemPersonel(SystemPersonel systemPersonel) {
		CheckRegisterRullers checkRegisterRullers = new CheckRegisterRullers();
		checkRegisterRullers.setUserList(userDao.findAll());
		
		boolean isContainMail = checkRegisterRullers.checkUserMail(systemPersonel.getMail());
		
		if(isContainMail) {
			System.out.println("Bu mail başkası tarafından alınmış. Şifrenizi unuttuysanız 'şifremi unuttum' butonuna tıklayınız.");
			return new ErrorResult("Kayıt gerçekleştirilemedi. Lütfen bilgilerinizi kontrol ediniz.");
			}
		
		systemPersonelDao.save(systemPersonel);
		
		return new SuccessResult("Kayıt işlemi gerçekleşti.");
	}
	
	
	
}
