package javacamp.hrms.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Value;

import javacamp.hrms.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MailValidation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int mailId;
	
	@Column
	@Value("${some.key:false}")
	private boolean statusMailValidation;
	
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

	public MailValidation(int mailId, boolean statusMailValidation, User user) {
		super();
		this.mailId = mailId;
		this.statusMailValidation = statusMailValidation;
		this.user = user;
	}

	public MailValidation() {	}

	public int getMailId() {
		return mailId;
	}

	public void setMailId(int mailId) {
		this.mailId = mailId;
	}

	public boolean isStatusMailValidation() {
		return statusMailValidation;
	}

	public void setStatusMailValidation(boolean statusMailValidation) {
		this.statusMailValidation = statusMailValidation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
