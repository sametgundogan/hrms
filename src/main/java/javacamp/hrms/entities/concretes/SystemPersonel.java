package javacamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="SystemPerosnel")
@PrimaryKeyJoinColumn(name="systemPersonelId")
@Data

public class SystemPersonel extends User{
	
	
	@Column(name = "personelId")
	private int id;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	

}
