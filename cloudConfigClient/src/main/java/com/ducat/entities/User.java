package com.ducat.entities;

import javax.validation.constraints.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class User {

	private int id;
	private String name,mailId, password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Pattern(regexp="[a-z,A-Z]{2}[a-z,A-Z, ]*",
	message="Name can contain only alphabets and space, min length 2.")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@NotEmpty(message="MailId can not be blank.")
	@Email(message="MailId should be in proper format.")
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	@Length(min=4,message="Must contain atleast 4 chars.")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
