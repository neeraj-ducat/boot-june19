package com.ducat.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ducat.daos.HeadOfStateDao;
import com.ducat.entities.*;
import java.util.*;

@Component
public class HosLoader {

	@Autowired
	HeadOfStateDao dao;
	
	public  void load() {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter Head of state Id: ");
		int id = in.nextInt();
		in.close();
		Optional<HeadOfState> opt = dao.findById(id);
		if(opt.isPresent())
		{
			HeadOfState hos = opt.get();
			System.out.println("Head of state details:");
			System.out.println(hos.getTitle()+"\t"+hos.getName());
			Country country = hos.getCountry();
			System.out.println("Country is: "+country.getName());
		}
		else
		{
			System.out.println("Invalid Id.");
		}
	
	}
}
