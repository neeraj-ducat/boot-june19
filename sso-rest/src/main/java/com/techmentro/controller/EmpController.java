package com.techmentro.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techmentro.entity.Emp;
import com.techmentro.repository.EmpRepository;

@RestController
public class EmpController {

	@Autowired
	EmpRepository empRepository;
	
	@GetMapping("/emps/{id}")
	public  Emp getEmp(@PathVariable int id,Principal principal) throws Exception
	{
		System.out.println(principal.getName()+" is requesting emp with id "+id);
		Emp emp = empRepository.findOne(id);

		if (emp == null)
			throw new Exception("Emp with id:" + id+" is not found.");

		return emp;
		
	}
	
	@GetMapping("/emps")
	public  Iterable<Emp> allEmp(Principal principal) {
		System.out.println(principal.getName()+" is requesting all employees");
		return empRepository.findAll();
	}
	
	
	@PostMapping(value= {"/emps"},produces= {"text/plain"},consumes= {"application/json"})
	public  String createStudent(@RequestBody Emp emp) {
		 empRepository.save(emp);
		 return "successfully saved.";
	}

	@PutMapping(value= {"/emps"},produces= {"text/plain"},consumes= {"application/json"})
	public  String updateStudent(@RequestBody Emp emp) {
		 empRepository.save(emp);
		 return "successfully updated.";
	}
	@DeleteMapping(value= {"/emps/{id}"},produces= {"text/plain"})
	public  String deleteStudent(@PathVariable int id) {
		empRepository.delete(id);
		return "successfully saved.";
	}

}
