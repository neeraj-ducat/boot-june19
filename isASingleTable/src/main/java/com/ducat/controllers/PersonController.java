package com.ducat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.daos.PersonDao;
import com.ducat.entities.Person;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	PersonDao dao;
	
	@PostMapping(value="/",consumes="application/json",
			produces="text/plain")
	public String save(@RequestBody Person p) {
		dao.save(p);
		return "successfully saved.";
	}
}
