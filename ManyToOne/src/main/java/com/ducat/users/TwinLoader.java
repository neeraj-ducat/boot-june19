package com.ducat.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ducat.daos.*;
import com.ducat.entities.*;
import java.util.*;

@Component
public class TwinLoader {

	@Autowired
	BatchDao bdao;
	@Autowired
	TrainerDao tdao;
	public  void load() {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter Trainer Id: ");
		int id = in.nextInt();
		
		Optional<Trainer> opt = tdao.findById(id);
		if(opt.isPresent())
		{
			Trainer tr = opt.get();
			System.out.println("Trainer Name: "+tr.getName());
			Set<Batch> set = tr.getBatches();
			System.out.println("Batches details:");
			for(Batch b: set)
				System.out.println(b.getSlot()+"\t"+b.getMode()+"\t"+b.getCourse());
		}
		else
		{
			System.out.println("Invalid Trainer Id.");
		}
		System.out.print("Enter Batch Id: ");
		id = in.nextInt();
		
		Optional<Batch> opt1 = bdao.findById(id);
		if(opt1.isPresent())
		{
		Batch b = opt1.get();	
		System.out.println("Batch details:");
		System.out.println(b.getSlot()+"\t"+b.getMode()+"\t"+b.getCourse());
		Trainer t = b.getTrainer();
		System.out.println("Trainer is: "+t.getName());
		}
		else
		{
			System.out.println("Invalid Batch Id.");
		}
		in.close();
	}
}
