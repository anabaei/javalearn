package com.example.easynotes.repository;

import com.example.easynotes.model.Reason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by TLC on 2018.
 */

@Repository
public interface ReasonRepository extends JpaRepository<Reason, Long> {

}
