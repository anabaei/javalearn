package com.sfutlc.sfutlc.controller;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import com.sfutlc.sfutlc.model.Greeting;
import com.sfutlc.sfutlc.services.GreetingService;

@RestController

public class GreetingController {
//
//    private static BigInteger nextId;
//    private static Map<BigInteger, Greeting> greetingMap;
//
//    private static Greeting save(Greeting greeting) {
//        if (greetingMap == null) {
//            greetingMap = new HashMap<BigInteger, Greeting>();
//            nextId = BigInteger.ONE;
//        }
//        if(greeting.getId() != null)
//        {
//        	Greeting oldGreeting = greetingMap.get(greeting.getId());
//           if(oldGreeting == null)
//           {
//        	   return null;
//           }
//           greetingMap.remove(greeting.getId());
//           greetingMap.put(greeting.getId(), greeting);
//           return greeting;
//        }
//        
//        greeting.setId(nextId);
//        nextId = nextId.add(BigInteger.ONE);
//        greetingMap.put(greeting.getId(), greeting);
//        return greeting;
//    }
//
//    private static boolean delete(BigInteger id) {
// 	   Greeting deletedGreeting = greetingMap.remove(id);
// 	   if(deletedGreeting == null)
// 	   {
// 		   return false;
// 	   }
// 	return true;
// }
//    
//    static {
//        Greeting g1 = new Greeting();
//        g1.setText("Hello World!");
//        ;
//        save(g1);
//
//        Greeting g2 = new Greeting();
//        g2.setText("Hola Mundo!");
//        save(g2);
//    }
	@Autowired
	private GreetingService greetingService;

    @RequestMapping(value = "/api/greetings")
    public ResponseEntity<Collection<Greeting>> getGreetings() {

        Collection<Greeting> greetings = greetingService.findAll();

        return new ResponseEntity<Collection<Greeting>>(greetings,
                HttpStatus.OK);
    }
    
    @RequestMapping(
    		value = "/api/greetings/{id}",
    		method = RequestMethod.GET,
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Greeting> getGreeting(@PathVariable("id") Long id)
    {
    	Greeting greeting = greetingService.findOne(id);
    	if (greeting == null)
    	  {
    	   return new ResponseEntity<Greeting>(HttpStatus.NOT_FOUND);	
    	  }
    return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);	
    }
    
    @RequestMapping(
    		value = "/api/greetings",
    		method = RequestMethod.POST,
    		produces = MediaType.APPLICATION_JSON_VALUE,
    		consumes = MediaType.APPLICATION_JSON_VALUE
    		)
     public ResponseEntity<Greeting> createGreeting(@RequestBody Greeting greeting) {
    	  Greeting savedGreeting = greetingService.create(greeting); 
    			  return new ResponseEntity<Greeting>(savedGreeting, HttpStatus.CREATED);
    }
    
    @RequestMapping( 
    		value = "/api/greetings/{id}",
    		method = RequestMethod.PUT,
    		produces = MediaType.APPLICATION_JSON_VALUE,
    		consumes = MediaType.APPLICATION_JSON_VALUE
    		)
    public ResponseEntity<Greeting> upfateGreeting(@RequestBody Greeting greeting){
    	Greeting updateGreeting = greetingService.update(greeting);
    	if(updateGreeting == null) {
    	   return new ResponseEntity<Greeting>(HttpStatus.INTERNAL_SERVER_ERROR);
    	   }
    	 
    	  return new ResponseEntity<Greeting>(updateGreeting, HttpStatus.OK);
    }
    @RequestMapping(
    		value="/api/greeting/{id}",
    		method = RequestMethod.DELETE,
    		produces = MediaType.APPLICATION_JSON_VALUE,
    		consumes = MediaType.APPLICATION_JSON_VALUE
    		
    		)
    public ResponseEntity<Greeting> deleteGreeting(
    		@PathVariable("id") Long id, 
    		@RequestBody Greeting greeting){
    	greetingService.delete(id);	 
    		 return new ResponseEntity<Greeting>(
    				 HttpStatus.NO_CONTENT 
    				 );			 
    	 
    }
    

}






















