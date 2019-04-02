package com.wander.notesapp.notesapplication.repository;


import org.springframework.data.repository.CrudRepository;

import com.wander.notesapp.notesapplication.model.User;

/**
 * The UserRepository class
 *
 * @author Muthukumar PL
 * @version 1.0
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

    User findByEmail(String email);
}