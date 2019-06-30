package com.ducat.users;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ducat.daos.TrainerDao;
import com.ducat.entities.*;

@Component
public class TrainerSaver {

	@Autowired
	TrainerDao dao;
	
	public  void save() {
		
		System.out.println("Saving Trainer objects...");
		Set<Batch> s1 = new HashSet<Batch>();
		s1.add(new Batch("10 to 12","W/E",".Net"));
		s1.add(new Batch("2 to 4","W/E","MVC"));
		s1.add(new Batch("4 to 6","W/E","ASP .Net"));
		Set<Batch> s2 = new HashSet<Batch>();
		s2.add(new Batch("8 to 10","W/D","Core Java"));
		s2.add(new Batch("10 to 12","W/D","Advance Java"));
		Trainer t1 = new Trainer("Amit",s1);
		Trainer t2 = new Trainer("Ravi",s2);
		dao.save(t1);
		dao.save(t2);
		System.out.println("successfully saved.");
	
	}
}
