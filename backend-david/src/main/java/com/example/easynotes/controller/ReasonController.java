package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Reason;
import com.example.easynotes.repository.ReasonRepository;
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

    @GetMapping("/reasons")
    public List<Reason> getAllReasons() {
        return reasonRepository.findAll();
    }

    @PostMapping("/reasons")
    public Reason createReason(@Valid @RequestBody Reason reason) {
        return reasonRepository.save(reason);
    }

    @GetMapping("/reasons/{id}")
    public Reason getReasonById(@PathVariable(value = "id") Long reasonId) {
       return reasonRepository.findById(reasonId)
                .orElseThrow(() -> new ResourceNotFoundException("Reason", "id", reasonId));
    }

    @PutMapping("/reasons/{id}")
    public Reason updateReason(@PathVariable(value = "id") Long reasonId,
                                           @Valid @RequestBody Reason reasonDetails) {

        Reason reason = reasonRepository.findById(reasonId)
                .orElseThrow(() -> new ResourceNotFoundException("Reason", "id", reasonId));

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

    @DeleteMapping("/reasons/{id}")
    public ResponseEntity<?> deleteReason(@PathVariable(value = "id") Long reasonId) {
        Reason reason = reasonRepository.findById(reasonId)
                .orElseThrow(() -> new ResourceNotFoundException("Reason", "id", reasonId));

        reasonRepository.delete(reason);

        return ResponseEntity.ok().build();
    }
}
