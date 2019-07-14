package com.techmentro.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techmentro.models.Emp;

@RestController
public class EmpController {

	@GetMapping("/emps")
	public List<Emp> getEmployees()
	{
		List<Emp> list=new ArrayList<Emp>();
		list.add(new Emp("Sara","Trainee",25000));
		list.add(new Emp("Swarnim","Trainer",45000));
		list.add(new Emp("Raman","Manager",76000));
		return list;
	}
}
