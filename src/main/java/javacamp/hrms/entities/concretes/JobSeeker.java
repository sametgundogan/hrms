package javacamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="job_seekers")

@PrimaryKeyJoinColumn(name="jobSeekerId")
@Data
public class JobSeeker extends User{
	
	@NotNull
	@Column(name="name", length=35)
	private String name;
	
	@NotNull
	@Column(name="last_name", length=35)
	private String lastName;
	
	@NotNull
	@Column(name="birth_year", length=4)
	private int birthYear;
	
	@NotNull
	@Column(name="tc_kimlik_no",length=11)
	private String tcId;
	
	public JobSeeker(String name, String lastName, int birthYear, String tcId, String mail, String password) {
		this.birthYear = birthYear;
		this.lastName = lastName;
		this.name = name;
		this.tcId = tcId;
		super.setMail(mail);
		super.setPassword(password);
	}

	public JobSeeker(String name, String lastName, int birthYear, String tcId) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.birthYear = birthYear;
		this.tcId = tcId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public String getTcId() {
		return tcId;
	}

	public void setTcId(String tcId) {
		this.tcId = tcId;
	}

}
