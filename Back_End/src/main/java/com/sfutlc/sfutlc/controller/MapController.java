package com.sfutlc.sfutlc.controller;

import com.sfutlc.sfutlc.exception.ResourceNotFoundException;
import com.sfutlc.sfutlc.model.Map;
import com.sfutlc.sfutlc.repository.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created on 2018.
 */
@RestController
@RequestMapping("/api/v1")
public class MapController {

    @Autowired
    MapRepository mapRepository;

    @GetMapping("/getAllMaps")
    public List<Map> getAllMaps() {
        return mapRepository.findAll();
    }

    @PostMapping("/createMap")
    public Map createMap(@Valid @RequestBody Map map) {
        return mapRepository.save(map);
    }

    @GetMapping("/getMap/{id}")
    public Map getMapById(@PathVariable(value = "id") Long mapId) {
       return mapRepository.findById(mapId)
                .orElseThrow(() -> new ResourceNotFoundException("Map", "id", mapId));
    }

    @PutMapping("/updateMap/{id}")
    public Map updateMap(@PathVariable(value = "id") Long mapId,
                                           @Valid @RequestBody Map mapDetails) {

        Map map = mapRepository.findById(mapId)
                .orElseThrow(() -> new ResourceNotFoundException("Map", "id", mapId));

        map.setConclusion(mapDetails.getConclusion());
        map.setReasons(mapDetails.getReasons());
        
        Map updatedMap = mapRepository.save(map);
        return updatedMap;
    }

    @DeleteMapping("/deleteMap/{id}")
    public ResponseEntity<?> deleteMap(@PathVariable(value = "id") Long mapId) {
        Map map = mapRepository.findById(mapId)
                .orElseThrow(() -> new ResourceNotFoundException("Map", "id", mapId));

        mapRepository.delete(map);

        return ResponseEntity.ok().build();
    }
    
    @RequestMapping(value = "/courses")
    public String getCourses() throws IOException {
    	
    	 System.out.print("came here!");
         String courses;
    	 // URL url = new URL("https://canvas.sfu.ca/api/v1/courses?per_page=500");
         URL url = new URL("https://canvas.instructure.com/api/v1/courses?per_page=500");
		   
	        HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
	        conn.setRequestProperty("Authorization", "Bearer 7~KQjDDpuTILTasCeW1nScQZKh9OL4FnfvhVcivdIEckRw92OuoHI0bxr9ZgqR2JFE");
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
                courses = sb.toString();
     
	        }
         return courses;             
    }
    
    
	@RequestMapping("/index")
	public String welcome() {
		
		return "index";
	}
}
