package com.ducat.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.entities.Emp;
import com.ducat.repositories.EmpDao;

@RestController
@RequestMapping("/employees")
public class EmpController {

	//Repository is autowired
	@Autowired
	EmpDao dao;
	
	// Method to return all the employees
	@GetMapping( value="/", produces="application/json")
	public Iterable<Emp> getAllEmp() {
		return dao.findAll();
	}
	
	// Method to return an the employees using id
	@GetMapping( value="/{id}", produces="application/json")
	public Emp getEmp(@PathVariable int id) {
	   Optional<Emp> fetched =	dao.findById(id);
	   if (fetched.isPresent())
		   return fetched.get();
	   else
		   return null;
	}
	
	// Method to return employees on the basis of job
	@GetMapping( value="/job/{job}", produces="application/json")
	public Iterable<Emp> getEmp(@PathVariable String job) {
	   return dao.findByJob(job);
	}
	
	// Method to save an Emp
	@PostMapping( value="/", produces="text/plain",
			consumes="application/json")
	public String save(@RequestBody Emp e) {
	     dao.save(e);
		 return "successfully saved.";
	}
	// Method to update an Emp
	@PutMapping( value="/", produces="text/plain",
			consumes="application/json")
	public String update(@RequestBody Emp e) {
	     dao.save(e);
		 return "successfully updated.";
	}
		
	// Method to save an Emp
	@DeleteMapping( value="/{id}", produces="text/plain")
	public String remove(@PathVariable int id) {
	     dao.deleteById(id);
		 return "successfully removed.";
	}	
}
