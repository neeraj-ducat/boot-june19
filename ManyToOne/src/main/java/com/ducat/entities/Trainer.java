package com.ducat.entities;

import java.util.Set;

import javax.persistence.*;

//Owned entity class.
@Entity
@Table(name="Trainers")
public class Trainer {

	// State of Country
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	// Relation of the Country
	@OneToMany(mappedBy="trainer",
			fetch=FetchType.EAGER)
	private  Set<Batch> batches;
	
	
	
	
	public Trainer() {
		super();
		
	}
	
	public Trainer(String name) {
		super();
		this.name = name;
	}

	public Trainer(String name, Set<Batch> batches) {
		super();
		this.name = name;
		this.batches = batches;
	}
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
	public Set<Batch> getBatches() {
		return batches;
	}
	public void setBatches(Set<Batch> batches) {
		this.batches = batches;
	}
	
	
	
	
	
}
