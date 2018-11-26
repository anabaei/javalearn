package com.sfutlc.sfutlc.repository;

import com.sfutlc.sfutlc.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by TLC on 2018.
 */

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
