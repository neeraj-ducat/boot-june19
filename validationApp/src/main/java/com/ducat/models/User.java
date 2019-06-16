package com.ducat.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class User {

	private int id;
	@Pattern(regexp="[a-z,A-Z]{2}[a-z,A-Z]*",message="Name can contain alphabets, min length 2")
	private String name;
	@NotEmpty(message="MailId is required.")
	@Email(message="MailId should be in proper format.")
	private String mailId;
	@Length(min=4, message="Password length must be at least 4 chars.")
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString() {
		return id+"\t"+name+"\t"+mailId+"\t"+password;
	}
	
}
