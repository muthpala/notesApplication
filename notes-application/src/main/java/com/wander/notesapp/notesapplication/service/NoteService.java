package com.wander.notesapp.notesapplication.service;


import java.util.List;

import com.wander.notesapp.notesapplication.model.Note;

/**
 * The NoteService interface
 *
 * @author Muthukumar PL
 * @version 1.0
 */
public interface NoteService {

    Note save(Note note);

    Boolean delete(int id);

    Note update(Note note);

    Note findById(int id);

    List<Note> findAll();

    List<Note> findByStatus(String status);

    List<Note> findByUserIdStatus(int userId, String status);

    List<Note> findBetween(int start, int end);

}
