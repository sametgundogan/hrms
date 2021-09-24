package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.concretes.SystemPersonel;

public interface SystemPersonelService {
	
	DataResult <List<SystemPersonel>> getAll();
	
	Result addSystemPersonel(SystemPersonel systemPersonel);
	

}
