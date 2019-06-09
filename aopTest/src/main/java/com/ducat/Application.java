package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.beans.ABC;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		System.out.println("Requesting ABC bean...");
		ABC target = (ABC)ctx.getBean("one");
		System.out.println("Received object is of type "+target.getClass().getName());
		System.out.println("Invoking a() of ABC...");
		target.a();
		System.out.println("Invoking b() of ABC...");
		String result = target.b();
		System.out.println(result+" is returned by b() in main.");
		System.out.println("Invoking c() of ABC...");
		try {
		target.c(-5);
		} catch (Exception e)
		{
			System.out.println("Following exception is caught in main: ");
			System.out.println(e);
		}
	}
}
