package com.sfutlc.sfutlc.repository;

import com.sfutlc.sfutlc.model.Reason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by TLC on 2018.
 */

@Repository
public interface ReasonRepository extends JpaRepository<Reason, Long> {
	@Query("SELECT r FROM Reason r where r.mapID = ?1")
	List<Reason> findByMapID(String mapID);
}
