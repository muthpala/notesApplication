package com.wander.notesapp.notesapplication;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wander.notesapp.notesapplication.controller.NoteController;
import com.wander.notesapp.notesapplication.controller.UserController;
import com.wander.notesapp.notesapplication.repository.NoteRepository;
import com.wander.notesapp.notesapplication.repository.UserRepository;
import com.wander.notesapp.notesapplication.service.NoteService;
import com.wander.notesapp.notesapplication.service.UserService;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NotesApplicationTests {

	@Autowired
	private UserController userController;
	
	@Autowired
	private NoteController noteController;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private NoteService noteService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private NoteRepository noteRepository;
	
	@Test
	public void contextLoads() {
		assertThat(userController).isNotNull();
		assertThat(noteController).isNotNull();
		assertThat(userService).isNotNull();
		assertThat(userRepository).isNotNull();
		assertThat(noteService).isNotNull();
		assertThat(noteRepository).isNotNull();
		
	}

}
