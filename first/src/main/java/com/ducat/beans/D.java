package com.ducat.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class D {

	
	private A a;
	
	@Autowired
	public D(A a) {
		this.a =a;
		System.out.println("D is created and A is injected.");
	}
	
	public void setA(A a) {
		this.a = a;
		System.out.println("setA() is invoked.");
	}
	public boolean hasA()
	{
		if (a == null)
			return false;
		else
			return true;
	}
	
}
