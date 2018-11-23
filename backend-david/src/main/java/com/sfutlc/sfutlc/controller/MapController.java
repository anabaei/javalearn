package com.sfutlc.sfutlc.controller;

import com.sfutlc.sfutlc.exception.ResourceNotFoundException;
import com.sfutlc.sfutlc.model.Map;
import com.sfutlc.sfutlc.repository.MapRepository;
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
}
