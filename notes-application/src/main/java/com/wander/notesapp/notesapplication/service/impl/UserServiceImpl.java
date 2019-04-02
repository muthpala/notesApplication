package com.wander.notesapp.notesapplication.service.impl;


import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.wander.notesapp.notesapplication.model.User;
import com.wander.notesapp.notesapplication.repository.UserRepository;
import com.wander.notesapp.notesapplication.service.UserService;

/**
 * The UserServiceImpl class
 *
 * @author Muthukumar PL
 * @version 1.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean delete(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Collection<User> findAll() {
        Iterable<User> itr = userRepository.findAll();
        return (Collection<User>) itr;
    }
}
