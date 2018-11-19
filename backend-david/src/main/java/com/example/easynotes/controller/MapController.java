package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Map;
import com.example.easynotes.repository.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created on 2018.
 */
@RestController
@RequestMapping("/api/v1")
public class MapController {

    @Autowired
    MapRepository mapRepository;

    @GetMapping("/maps")
    public List<Map> getAllMaps() {
        return mapRepository.findAll();
    }

    @PostMapping("/maps")
    public Map createMap(@Valid @RequestBody Map map) {
        return mapRepository.save(map);
    }

    @GetMapping("/maps/{id}")
    public Map getMapById(@PathVariable(value = "id") Long mapId) {
       return mapRepository.findById(mapId)
                .orElseThrow(() -> new ResourceNotFoundException("Map", "id", mapId));
    }

    @PutMapping("/maps/{id}")
    public Map updateMap(@PathVariable(value = "id") Long mapId,
                                           @Valid @RequestBody Map mapDetails) {

        Map map = mapRepository.findById(mapId)
                .orElseThrow(() -> new ResourceNotFoundException("Map", "id", mapId));

        map.setMapID(mapDetails.getMapID());
        map.setAssignment(mapDetails.getAssignment());
        map.setTitle(mapDetails.getTitle());
        map.setThesisBlue(mapDetails.getThesisBlue());
        map.setThesisYellow(mapDetails.getThesisYellow());
        map.setConclusion(mapDetails.getConclusion());
        
        Map updatedMap = mapRepository.save(map);
        return updatedMap;
    }

    @DeleteMapping("/maps/{id}")
    public ResponseEntity<?> deleteMap(@PathVariable(value = "id") Long mapId) {
        Map map = mapRepository.findById(mapId)
                .orElseThrow(() -> new ResourceNotFoundException("Map", "id", mapId));

        mapRepository.delete(map);

        return ResponseEntity.ok().build();
    }
}
