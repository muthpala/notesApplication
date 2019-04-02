package com.wander.notesapp.notesapplication.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wander.notesapp.notesapplication.model.Note;
import com.wander.notesapp.notesapplication.model.User;
import com.wander.notesapp.notesapplication.service.NoteService;
import com.wander.notesapp.notesapplication.service.UserService;
import com.wander.notesapp.notesapplication.utils.PassEncoding;
import com.wander.notesapp.notesapplication.utils.Roles;
import com.wander.notesapp.notesapplication.utils.Status;

/**
 * The UserController  Class
 *
 * @author Muthukumar PL
 * @version 1.0
 */
@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    GlobalController globalController;

    NoteService noteService;

    UserService userService;

    public UserController(GlobalController globalController, NoteService noteService, UserService userService) {
		super();
		this.globalController = globalController;
		this.noteService = noteService;
		this.userService = userService;
	}

	@RequestMapping("/")
    public String root(Model model) {
        model.addAttribute("reqUser", new User());
        logger.info("root");
        return "login";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("reqUser", new User());
        logger.info("login");
        return "login";
    }

    @RequestMapping("/home")
    public String home(Model model) {
        Note note =new Note();
        model.addAttribute("reqNote", note);
        model.addAttribute("allNote", noteService.findByUserIdStatus(globalController.getLoginUser().getId(), Status.ACTIVE.getValue()));
        model.addAttribute("allPassiveNote", noteService.findByUserIdStatus(globalController.getLoginUser().getId(), Status.PASSIVE.getValue()));
        logger.info("home");
        return "home";
    }

    @RequestMapping("/admin")
    public String admin(Model model) {
        logger.info("admin");
        Note note =new Note();
        model.addAttribute("reqNote", note);
        model.addAttribute("allNote", noteService.findByStatus(Status.ACTIVE.getValue()));
        model.addAttribute("allPassiveNote", noteService.findByStatus(Status.PASSIVE.getValue()));
        return "admin";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("reqUser", new User());
        logger.info("register");
        return "register";
    }

    @PostMapping("/user/register")
    public String register(@ModelAttribute("reqUser") User reqUser,
                           final RedirectAttributes redirectAttributes) {

        logger.info("/user/register");
        User user = userService.findByUserName(reqUser.getUsername());
        if (user != null) {
            redirectAttributes.addFlashAttribute("saveUser", "exist-name");
            return "redirect:/register";
        }
        user = userService.findByEmail(reqUser.getEmail());
        if (user != null) {
            redirectAttributes.addFlashAttribute("saveUser", "exist-email");
            return "redirect:/register";
        }

        reqUser.setPassword(PassEncoding.getInstance().passwordEncoder.encode(reqUser.getPassword()));
        reqUser.setRole(Roles.ROLE_USER.getValue());

        if (userService.save(reqUser) != null) {
            redirectAttributes.addFlashAttribute("saveUser", "success");
        } else {
            redirectAttributes.addFlashAttribute("saveUser", "fail");
        }

        return "redirect:/register";
    }


}
