package com.ducat.entities;

import javax.persistence.*;
//Owner entity class

@Entity
@Table(name="Batches")
public class Batch {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String slot, mode, course;
	//Relation
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="trainerId")
	Trainer trainer;
	
	public Batch() {
		super();
	}

	public Batch(String slot, String mode, String course, Trainer trainer) {
		super();
		this.slot = slot;
		this.mode = mode;
		this.course = course;
		this.trainer = trainer;
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



	public Trainer getTrainer() {
		return trainer;
	}



	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	
	
	
	
}
