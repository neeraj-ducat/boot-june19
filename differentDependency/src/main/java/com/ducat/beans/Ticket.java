package com.ducat.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Scope("prototype")
public class Ticket {

	// property to give unique number to each ticket
	private static int counter = 0;
	// unique number of each ticket
	private int no;
	
	public Ticket()
	{
		no = ++counter;
		System.out.println("Ticket no "+no+" is created.");
	}
	// To facilitate printing of Tickets in print()/println()
	public String toString()
	{
		return "It is ticket number "+no;
	}
}
