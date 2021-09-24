package javacamp.hrms.entities.concretes;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class HrmsValidation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hrmsId;
	
	@Value("${some.key:false}")
	private boolean statusHrmsValidation;
	
	@OneToOne
	@JoinColumn(name = "employerId")
	@JsonIgnore
	private Employer employer;

	public HrmsValidation(int hrmsId, boolean statusHrmsValidation, Employer employer) {
		super();
		this.hrmsId = hrmsId;
		this.statusHrmsValidation = statusHrmsValidation;
		this.employer = employer;
	}

	public HrmsValidation() {
		// TODO Auto-generated constructor stub
	}

	public int getHrmsId() {
		return hrmsId;
	}

	public void setHrmsId(int hrmsId) {
		this.hrmsId = hrmsId;
	}

	public boolean isStatusHrmsValidation() {
		return statusHrmsValidation;
	}

	public void setStatusHrmsValidation(boolean statusHrmsValidation) {
		this.statusHrmsValidation = statusHrmsValidation;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
}
