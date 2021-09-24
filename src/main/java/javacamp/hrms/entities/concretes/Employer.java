package javacamp.hrms.entities.concretes;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Employer")
@PrimaryKeyJoinColumn(name="employerId")
public class Employer extends User{
	

	@Column(name="companyName", nullable = false)
	private String companyName;
	
	@Column(name = "website", nullable = false)
	private String website;

	@Column(name="phoneNumber", nullable = false, length = 11)
	private String phoneNumber;
	
	@OneToOne(mappedBy="employer", cascade = CascadeType.ALL)
	private HrmsValidation hrmsValidation;

	public Employer(String companyName, String website, String phoneNumber, HrmsValidation hrmsValidation) {
		super();
		this.companyName = companyName;
		this.website = website;
		this.phoneNumber = phoneNumber;
		this.hrmsValidation = hrmsValidation;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public HrmsValidation getHrmsValidation() {
		return hrmsValidation;
	}

	public void setHrmsValidation(HrmsValidation hrmsValidation) {
		this.hrmsValidation = hrmsValidation;
	}
	
	

}
