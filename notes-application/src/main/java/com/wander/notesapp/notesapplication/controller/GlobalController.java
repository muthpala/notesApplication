package com.wander.notesapp.notesapplication.controller;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.wander.notesapp.notesapplication.model.User;
import com.wander.notesapp.notesapplication.service.UserService;

/**
 * The GlobalController  Class
 *
 * @author Muthukumar PL
 * @version 1.0
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GlobalController {

    private UserService userService;
    
    private User loginUser;

    public GlobalController(UserService userService) {
		super();
		this.userService = userService;
	}


    public User getLoginUser() {
        if (loginUser == null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            loginUser = userService.findByUserName(auth.getName());
        }
        return loginUser;
    }
}
