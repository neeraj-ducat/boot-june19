package com.ducat.entities;

import javax.persistence.*;
//Owned entity class

@Entity
@Table(name="Batches")
public class Batch {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String slot, mode, course;
	
	
	
	public Batch() {
		super();
	}



	public Batch(String slot, String mode, String course) {
		super();
		this.slot = slot;
		this.mode = mode;
		this.course = course;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getSlot() {
		return slot;
	}



	public void setSlot(String slot) {
		this.slot = slot;
	}



	public String getMode() {
		return mode;
	}



	public void setMode(String mode) {
		this.mode = mode;
	}



	public String getCourse() {
		return course;
	}



	public void setCourse(String course) {
		this.course = course;
	}
	
	
	
	
}
