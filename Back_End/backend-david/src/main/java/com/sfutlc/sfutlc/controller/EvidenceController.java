package com.sfutlc.sfutlc.controller;

import com.sfutlc.sfutlc.exception.ResourceNotFoundException;
import com.sfutlc.sfutlc.model.Evidence;
import com.sfutlc.sfutlc.repository.EvidenceRepository;
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
public class EvidenceController {

    @Autowired
    EvidenceRepository evidenceRepository;

    @GetMapping("/evidences")
    public List<Evidence> getAllEvidences() {
        return evidenceRepository.findAll();
    }

    @PostMapping("/evidences")
    public Evidence createEvidence(@Valid @RequestBody Evidence evidence) {
        return evidenceRepository.save(evidence);
    }

    @GetMapping("/evidences/reason/{reasonID}")
    public List<Evidence> getEvidencesByReasonID(@PathVariable(value = "reasonID") String reasonID) {
        return evidenceRepository.findByReasonID(reasonID);
    }
    
    @GetMapping("/evidences/{id}")
    public Evidence getEvidencesById(@PathVariable(value = "id") Long id) {
    	return  evidenceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reason", "id", id));
    }
    @PutMapping("/evidences/{id}")
    public Evidence updateEvidence(@PathVariable(value = "id") Long evidenceId,
                                           @Valid @RequestBody Evidence evidenceDetails) {

        Evidence evidence = evidenceRepository.findById(evidenceId)
                .orElseThrow(() -> new ResourceNotFoundException("Evidence", "id", evidenceId));

        evidence.setEvidenceID(evidenceDetails.getEvidenceID());
        evidence.setReasonID(evidenceDetails.getReasonID());
        evidence.setSupport(evidenceDetails.getSupport());
        evidence.setEvidenceContent(evidenceDetails.getEvidenceContent());
        evidence.setWarrantContent(evidenceDetails.getWarrantContent());
        
        

        Evidence updatedEvidence = evidenceRepository.save(evidence);
        return updatedEvidence;
    }

    @DeleteMapping("/evidences/{id}")
    public ResponseEntity<?> deleteEvidence(@PathVariable(value = "id") Long evidenceId) {
        Evidence evidence = evidenceRepository.findById(evidenceId)
                .orElseThrow(() -> new ResourceNotFoundException("Evidence", "id", evidenceId));

        evidenceRepository.delete(evidence);

        return ResponseEntity.ok().build();
    }
}
