package com.ducat.users;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ducat.daos.TrainerDao;
import com.ducat.entities.*;

@Component
public class Loader {

	@Autowired
	TrainerDao dao;
	
	public  void load() {
		
		System.out.println("Loading Trainer objects...");
		Iterable<Trainer> itr =  dao.findAll();
		System.out.println("Following trainers are loaded:");
		for(Trainer tr : itr) {
			System.out.println("Name: "+tr.getName());
			Set<Batch> set = tr.getBatches();
			System.out.println("Batches of the trainer:");
			for(Batch b: set)
			{
				System.out.println(b.getSlot()+"\t"+b.getMode()+"\t"+b.getCourse());
			}
		}
	
	}
}
