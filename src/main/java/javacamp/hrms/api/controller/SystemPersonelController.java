package javacamp.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.SystemPersonelService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.concretes.SystemPersonel;

@RestController
@RequestMapping("/api/systemPersonel")
public class SystemPersonelController {

	SystemPersonelService systemPersonelService;
	
	@Autowired
	public SystemPersonelController(SystemPersonelService systemPersonelService) {
		this.systemPersonelService = systemPersonelService;
		
	}
	
	@GetMapping("/getAll")
	public DataResult<List<SystemPersonel>> getAll(){
		return systemPersonelService.getAll();
		}
	
	@PostMapping(value = "/addNew")
	public Result addSysremPersonel(@RequestBody SystemPersonel systemPersonel) {
		return systemPersonelService.addSystemPersonel(systemPersonel);
	}
}
