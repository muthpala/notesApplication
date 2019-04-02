package com.wander.notesapp.notesapplication.service.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.wander.notesapp.notesapplication.model.Note;
import com.wander.notesapp.notesapplication.repository.NoteRepository;
import com.wander.notesapp.notesapplication.service.NoteService;

/**
 * The NoteServiceImpl class
 *
 * @author Muthukumar PL
 * @version 1.0
 */
@Service
@Transactional
public class NoteServiceImpl implements NoteService {

    private NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository NoteRepository) {
		super();
		this.noteRepository = NoteRepository;
	}

	@Override
    public Note save(Note Note) {
        return noteRepository.save(Note);
    }

    @Override
    public Boolean delete(int id) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Note update(Note Note) {
        return noteRepository.save(Note);
    }

    @Override
    public Note findById(int id) {
        return noteRepository.findById(id).get();
    }

    @Override
    public List<Note> findAll() {
        return (List<Note>) noteRepository.findAll();
    }

    @Override
    public List<Note> findByStatus(String status) {
        return noteRepository.findByStatus(status);
    }

    @Override
    public List<Note> findByUserIdStatus(int userId, String status) {
        //return  NoteRepository.findByUserIdStatus(userId, status);
        return  noteRepository.findByUserIdAndStatus(userId, status);
    }

    @Override
    public List<Note> findBetween(int start, int end) {
        return noteRepository.findBetween(start, end);
    }
}
