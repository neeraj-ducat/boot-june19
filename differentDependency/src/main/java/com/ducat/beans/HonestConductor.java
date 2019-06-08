package com.ducat.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class HonestConductor extends Conductor {

	// Dependency of the container
	@Autowired
	ApplicationContext ctx;
	
	@Override
	public Ticket getTicket() {
		return (Ticket)ctx.getBean("ticket");
	}

}
