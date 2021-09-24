package javacamp.hrms.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import javacamp.hrms.core.entities.MailValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy=InheritanceType.JOINED)

@Data
@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	@Column(name="userId", nullable=false, unique = true)
	private int id;
	
	@NotNull
	@Column(name="mail",nullable=false)
	private String mail;

	@NotNull
	@Column(name="password",nullable=false)
	private String password;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private MailValidation mailValidation;

	public User() {}
	public User(int id, String mail, String password, MailValidation mailValidation) {
		super();
		this.id = id;
		this.mail = mail;
		this.password = password;
		this.mailValidation = mailValidation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MailValidation getMailValidation() {
		return mailValidation;
	}

	public void setMailValidation(MailValidation mailValidation) {
		this.mailValidation = mailValidation;
	}
	
	

}
