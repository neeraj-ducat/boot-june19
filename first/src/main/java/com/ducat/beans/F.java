package com.ducat.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class F {

	@Bean()
	@Lazy
	public E getE()
	{
		System.out.println("getE() of F is invoked.");
		return new E();
	}
}
