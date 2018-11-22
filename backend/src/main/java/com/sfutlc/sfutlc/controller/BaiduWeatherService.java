package com.sfutlc.sfutlc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BaiduWeatherService {
	
	  
	  public BaiduWeatherService() {
	  
		   
		 try { 
		    URL url = new URL("https://api.github.com/users");
		   
	        HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
	      //  conn.setRequestProperty("apikey",apiKey);
	        
	        if (conn.getResponseCode() != 200) {
	            
				throw new RuntimeException("HTTP GET Request Failed with Error code : "
	                          + conn.getResponseCode());
	        }
	        else {
	        	System.out.print("DSSDSDSDSDSDDDSDSDSDSDSDSDSDSDSDSDSSSDSDSDSDSDSDSDSDS");
	        }
	        
	        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
	        String output = null;  
	        Object strBuf;
		//	while ((output = reader.readLine()) != null)  
	          //  strBuf.append(output);  
	    }catch(MalformedURLException e) {  
	        e.printStackTrace();   
	    }catch(IOException e){  
	        e.printStackTrace();   
	    }
	  
	  }        
}
