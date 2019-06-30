package com.ducat.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ducat.daos.CountryDao;
import com.ducat.entities.*;

@Component
public class CountrySaver {

	@Autowired
	CountryDao dao;
	
	public  void save() {
		
		System.out.println("Saving country objects...");
		Country c1 = new Country("India", 
				new HeadOfState("President","R.N.Kovind"));
		Country c2 = new Country("UK", 
				new HeadOfState("Queen","Elizabeth II"));
		dao.save(c1);
		dao.save(c2);
		System.out.println("successfully saved.");
	
	}
}
