package com.sfutlc.sfutlc.repository;

import com.sfutlc.sfutlc.model.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

/**
 * Created by TLC on 2018.
 */

@Repository
public interface EvidenceRepository extends JpaRepository<Evidence, Long> {
	@Query("SELECT e FROM Evidence e where e.reasonID = ?1")
	List<Evidence> findByReasonID(String reasonID);

}
