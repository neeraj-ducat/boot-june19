package com.ducat.entities;

import javax.persistence.*;

@Entity
@Table(name="Emp")
public class Emp extends Person {

	private String job;
	private int salary;
	
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}
