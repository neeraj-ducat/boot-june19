package com.ducat.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
// Its scope is by default sigleton.
public class DishonestConductor extends Conductor {

	// Dependency of the Conductor
	@Autowired
	private Ticket ticket;
	
	@Override
	public Ticket getTicket() {
		
		return ticket;
	}

}
