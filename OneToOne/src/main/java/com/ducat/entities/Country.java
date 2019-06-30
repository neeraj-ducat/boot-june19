package com.ducat.entities;

import javax.persistence.*;

//Owner entity class.
@Entity
@Table(name="Countries")
public class Country {

	// State of Country
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	// Relation of the Country
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="hosId")
	private  HeadOfState hos;
	
	
	
	public Country() {
		super();
	}
	public Country(String name, HeadOfState hos) {
		super();
		this.name = name;
		this.hos = hos;
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
	public HeadOfState getHos() {
		return hos;
	}
	public void setHos(HeadOfState hos) {
		this.hos = hos;
	}
	
	
}
