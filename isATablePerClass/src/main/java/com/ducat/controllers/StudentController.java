package com.ducat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.daos.StudentDao;
import com.ducat.entities.Student;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentDao dao;
	
	@PostMapping(value="/",consumes="application/json",
			produces="text/plain")
	public String save(@RequestBody Student s) {
		dao.save(s);
		return "successfully saved.";
	}
}
