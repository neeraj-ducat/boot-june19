package com.ducat.entities;

import java.util.Set;

import javax.persistence.*;

//Owner entity class.
@Entity
@Table(name="Trainers")
public class Trainer {

	// State of Country
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	// Relation of the Country
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},
			fetch=FetchType.EAGER)
	@JoinTable(name="Trainer_Batch",
	joinColumns= {@JoinColumn(name="trainerId")},
	inverseJoinColumns= {@JoinColumn(name="batchId")})
	private  Set<Batch> batches;
	
	
	
	
	public Trainer() {
		super();
		
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
