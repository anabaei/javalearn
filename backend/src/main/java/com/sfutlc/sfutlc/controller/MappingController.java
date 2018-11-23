package com.sfutlc.sfutlc.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sfutlc.sfutlc.configuration.SecurityConfig;
import com.sfutlc.sfutlc.model.Mapping;
import com.sfutlc.sfutlc.services.GreetingService;




@RestController
public class MappingController {
	
	

    private static BigInteger nextId;
    private static Map<BigInteger, Mapping> mappingMap;

    private static Mapping save(Mapping mapping) {
        if (mappingMap == null) {
        	mappingMap = new HashMap<BigInteger, Mapping>();
            nextId = BigInteger.ONE;
        }
        mapping.setMapID(nextId);
        nextId = nextId.add(BigInteger.ONE);
        mappingMap.put(mapping.getMapID(), mapping);
        return mapping;
    }

    static {
        Mapping g1 = new Mapping();
        g1.setTitle("Are dialectical maps an effective teaching tool?");
        g1.setAssignment("Assignment1");
        g1.setCreationDate(1541463733);
        g1.setLastEditedDate(1541463734);
        g1.setTheisBlue("Pro/Agree");
        g1.setTheisYellow("Con/Disagree");
        g1.setConclusion("Dialectical maps are a great tool to help students dissect two different stances on an argument.  There is a slight learning curve initially, but the structure of the maps helps students to organize their thoughts and improve their confidence in debate situations.");
        
        List<Map<String, Object>> myListOfMaps = new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("reasonID", 99);
        map1.put("mapID", 0);
        map1.put("strength", 99);
        map1.put("isBlue", true);
        map1.put("content", "They help students learn.");
        map1.put("expanded", true);
        myListOfMaps.add(map1);
        g1.setReasons(myListOfMaps); 
        
        List<Map<String, Object>> evidences = new ArrayList<Map<String, Object>>();
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("evidenceID", 33);
        map2.put("mapID", 0);
        map2.put("reasonID", 99);
        map2.put("supports", false);
        map2.put("evidenceContent", "abc");
        map2.put("warrantContent", "def");
        evidences.add(map2);
        
        g1.setEvidences(evidences);
        

        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("reasonID", 100);
        map3.put("mapID", 0);
        map3.put("strength", 4);
        map3.put("isBlue", false);
        map3.put("content", "They are hard to use");
        map3.put("expanded", true);
        myListOfMaps.add(map3);
        g1.setReasons(myListOfMaps); 
        

        Map<String, Object> map4 = new HashMap<String, Object>();
        map4.put("evidenceID", 444);
        map4.put("mapID", 0);
        map4.put("reasonID", 100);
        map4.put("supports", true);
        map4.put("evidenceContent", "ghi");
        map4.put("warrantContent", "jkl");
        evidences.add(map4);
        
        g1.setEvidences(evidences);		
        
        save(g1);

        Mapping g2 = new Mapping();
        g2.setTitle("Hola Mundo!");
        save(g2);
    }
    


    
    @RequestMapping(value = "/api/v1/map")
    public ResponseEntity<Collection<Mapping>> getGreetings() throws IOException {
    	
    	
    	
    	   
    	
          ////////////////////////////////////////////
         ///////// TESTING ENDPOINT CANVAS //////////
         ////////////////////////////////////////////
    	 URL url = new URL("https://api.github.com/users");
		   
	        HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
	      //  conn.setRequestProperty("apikey",apiKey);
	        
	        if (conn.getResponseCode() != 200 && conn.getResponseCode() != 201) {
	            
				throw new RuntimeException("HTTP GET Request Failed with Error code : "
	                          + conn.getResponseCode());
	        }
	        else {
	        	
	        	BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line+"\n");
                }
                br.close();
                String ss = sb.toString();
                System.out.print(sb.toString());
                
                Gson gson = new Gson();
                
                
                Map<String, Object>[] ints2 =  gson.fromJson(ss, Map[].class); 
                System.out.println(ss.length());
                
                System.out.println(ints2[0]);
//                
//                GsonBuilder builder = new GsonBuilder();
//
//                builder.serializeNulls();
//
//                //Gson gson = builder.create();
//
//                
//                String json = "{\"brand\":\"Jeep\", \"doors\": 3}";
//
//                Gson gson = new Gson();
//
//                Car car = gson.fromJson(json, Car.class);
//                
//                Properties data = gson.fromJson(ss, Properties.class);
//                String imgurl = data.getProperty("login");
//                
                
                //Collection<Car> enums = gson.toJson(car, collectionType);
                
               // String json = "{\"brand\":\"Jeep\", \"doors\": 3}";

              // System.out.print(imgurl);
                
                
                
	        }
    	
       
        Collection<Mapping> mappings = mappingMap.values();

        return new ResponseEntity<Collection<Mapping>>(mappings,
                HttpStatus.OK);
    }
    

}




































