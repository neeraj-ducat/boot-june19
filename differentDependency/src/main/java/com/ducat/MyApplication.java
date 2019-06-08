package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.beans.Conductor;
import com.ducat.beans.Ticket;

@SpringBootApplication
public class MyApplication {

	public static void main(String[] args) {
		// Application is booted and reference of
		// IOC container i.e ApplicationContext is obtained
	  ApplicationContext ctx =	SpringApplication.run(MyApplication.class, args);
	  System.out.println("Requesting conductor from IOC container...");
	  // Conductor con = (Conductor) ctx.getBean("dishonestConductor");
	  // Conductor con = (Conductor) ctx.getBean("honestConductor");
	  Conductor con = (Conductor) ctx.getBean("conductor");
	  System.out.println("Conductor object class is: "+con.getClass().getName());
	  System.out.println("Requesting two tickets from the conductor...");
	  Ticket t1 = con.getTicket();
	  Ticket t2 = con.getTicket();
	  System.out.println("Desc of first Ticket: "+t1);
	  System.out.println("Desc of second Ticket: "+t2);
	}

}
