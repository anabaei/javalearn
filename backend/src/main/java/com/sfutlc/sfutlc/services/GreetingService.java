package com.sfutlc.sfutlc.services;

import java.util.Collection;

import com.sfutlc.sfutlc.model.Greeting;

public interface GreetingService {
	
	Collection<Greeting> findAll();
	Greeting findOne(Long id);
	Greeting create(Greeting greeting);
	Greeting update(Greeting greeting);
    void delete(Long id);
 
}
