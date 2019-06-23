package com.ducat.entities;

import javax.persistence.*;

@Entity
@Table(name="Students")
public class Student extends Person {

	private String course;
	private int fee;
	
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	
	
}
