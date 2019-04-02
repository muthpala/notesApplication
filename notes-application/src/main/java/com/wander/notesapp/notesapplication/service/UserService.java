package com.wander.notesapp.notesapplication.service;


import java.util.Collection;

import com.wander.notesapp.notesapplication.model.User;

/**
 * The UserService interface
 *
 * @author Muthukumar PL
 * @version 1.0
 */
public interface UserService {

    User save(User user);

    Boolean delete(int id);

    User update(User user);

    User findById(int id);

    User findByUserName(String username);

    User findByEmail(String email);

    Collection<User> findAll();
}
