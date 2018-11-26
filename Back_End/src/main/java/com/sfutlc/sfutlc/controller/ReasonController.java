package com.sfutlc.sfutlc.controller;

import com.sfutlc.sfutlc.exception.ResourceNotFoundException;
import com.sfutlc.sfutlc.model.Reason;
import com.sfutlc.sfutlc.repository.ReasonRepository;
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
public class ReasonController {

    @Autowired
    ReasonRepository reasonRepository;

    @GetMapping("/getAllReasons")
    public List<Reason> getAllReasons() {
        return reasonRepository.findAll();
    }

    @PostMapping("/createReason")
    public Reason createReason(@Valid @RequestBody Reason reason) {
        return reasonRepository.save(reason);
    }
    
    @GetMapping("/getReasons/{mapID}")
    public List<Reason> getReasonByMapID(@PathVariable(value = "mapID") String mapID) {
       return reasonRepository.findByMapID(mapID);
    }
    
    @GetMapping("/getSingleReason/{id}")
    public Reason getReasonById(@PathVariable(value = "id") Long reasonId) {
    	
    	Reason reason = reasonRepository.findById(reasonId)
                .orElseThrow(() -> new ResourceNotFoundException("Reason", "id", reasonId));
    	return reason;
    }

    @PutMapping("/updateReason/{id}")
    public Reason updateReason(@PathVariable(value = "id") Long reasonId,
                                           @Valid @RequestBody Reason reasonDetails) {

        Reason reason = reasonRepository.findById(reasonId)
                .orElseThrow(() -> new ResourceNotFoundException("Reason", "id", reasonId));

        reason.setReasonID(reasonDetails.getReasonID());
        reason.setStrength(reasonDetails.getStrength());
        reason.setMapID(reasonDetails.getMapID());
        reason.setContent(reasonDetails.getContent());
        reason.setReasonOrder(reasonDetails.getReasonOrder());
        reason.setIsBlue(reasonDetails.getIsBlue());
        reason.setLinked(reasonDetails.getLinked());
        reason.setExpanded(reasonDetails.getExpanded());

        Reason updatedReason = reasonRepository.save(reason);
        return updatedReason;
    }

    @DeleteMapping("/deleteReason/{id}")
    public ResponseEntity<?> deleteReason(@PathVariable(value = "id") Long reasonId) {
        Reason reason = reasonRepository.findById(reasonId)
                .orElseThrow(() -> new ResourceNotFoundException("Reason", "id", reasonId));

        reasonRepository.delete(reason);

        return ResponseEntity.ok().build();
    }
}
