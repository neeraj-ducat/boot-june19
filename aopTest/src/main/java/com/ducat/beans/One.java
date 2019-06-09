package com.ducat.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class One implements ABC {

	public void a() {
		System.out.println("a() of One is invoked.");

	}

	public String b() {
		System.out.println("b() of One is invoked, returning success...");
		return "success";
	}

	public void c(int x) throws Exception {
		System.out.print("c() of One is invoked, ");
		if ( x <= 0)
		{
			System.out.println("throwing exception");
			throw(new Exception("parameter should be > 0"));
		}
		else
		{
			System.out.println("returning normally");
		}

	}

}
