package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.beans.*;

@SpringBootApplication
public class MyApplication {

	public static void main(String[] args) {
		
	  ApplicationContext ctx =	SpringApplication.run(MyApplication.class, args);
	  System.out.println("Requesting B bean...");
	  B b = (B)ctx.getBean("b");
	  if (b.hasA())
		  System.out.println("B has A bean.");
	  else
		  System.out.println("B doesn't have A bean.");
	  
	  System.out.println("Requesting C bean...");
	  C c = (C)ctx.getBean("c");
	  if (c.hasA())
		  System.out.println("C has A bean.");
	  else
		  System.out.println("C doesn't have A bean.");
	  
	  System.out.println("Requesting D bean...");
	  D d = (D)ctx.getBean("d");
	  if (d.hasA())
		  System.out.println("D has A bean.");
	  else
		  System.out.println("D doesn't have A bean.");
	  
	  System.out.println("Requesting E bean...");
	  E e = (E)ctx.getBean(E.class);
	}

}
