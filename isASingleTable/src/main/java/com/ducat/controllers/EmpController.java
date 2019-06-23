package com.ducat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.daos.EmpDao;
import com.ducat.entities.Emp;

@RestController
@RequestMapping("/employees")
public class EmpController {

	@Autowired
	EmpDao dao;
	
	@PostMapping(value="/",consumes="application/json",
			produces="text/plain")
	public String save(@RequestBody Emp e) {
		dao.save(e);
		return "successfully saved.";
	}
}
