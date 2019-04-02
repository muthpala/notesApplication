package com.wander.notesapp.notesapplication.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wander.notesapp.notesapplication.model.Note;

/**
 * The NoteRepository class
 *
 * @author Muthukumar PL
 * @version 1.0
 */
public interface NoteRepository extends CrudRepository<Note, Integer> {

    List<Note> findByStatus(String status);

    List<Note> findByUserIdAndStatus(int userId,  String status);

    @Query("from Note note where note.id BETWEEN  :start and :end")
    List<Note> findBetween(@Param("start") int start, @Param("end") int end);

}