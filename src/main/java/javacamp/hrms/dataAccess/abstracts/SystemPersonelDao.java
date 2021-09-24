package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.SystemPersonel;

public interface SystemPersonelDao extends JpaRepository<SystemPersonel, Integer>{

}
