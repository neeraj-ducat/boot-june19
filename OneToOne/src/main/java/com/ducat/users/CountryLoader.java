package com.ducat.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ducat.daos.CountryDao;
import com.ducat.entities.*;

@Component
public class CountryLoader {

	@Autowired
	CountryDao dao;
	
	public  void load() {
		
		System.out.println("Loading country objects...");
		Iterable<Country> itr =  dao.findAll();
		System.out.println("Following countries are loaded:");
		for(Country country : itr) {
			System.out.println("Name: "+country.getName());
			HeadOfState hos = country.getHos();
			System.out.println("Head of state details: "+hos.getTitle()+"\t"+hos.getName());
		}
	
	}
}
