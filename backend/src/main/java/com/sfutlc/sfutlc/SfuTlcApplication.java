package com.sfutlc.sfutlc;

/*******************************************************
          Starting point of the application
********************************************************/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SfuTlcApplication {
	
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(SfuTlcApplication.class);
	    }
	 
	
	

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SfuTlcApplication.class, args);
	}
}
