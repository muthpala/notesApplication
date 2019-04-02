package com.wander.notesapp.notesapplication.controller;


import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wander.notesapp.notesapplication.model.Note;
import com.wander.notesapp.notesapplication.service.NoteService;
import com.wander.notesapp.notesapplication.utils.Status;

/**
 * The NoteController  Class
 *
 * @author Muthukumar PL
 * @version 1.0
 */
@Controller
@ComponentScan
public class NoteController {

    private static final Logger logger = LoggerFactory.getLogger(NoteController.class);

    private NoteService noteService;
    
    private GlobalController globalController;

    public NoteController(NoteService noteService, GlobalController globalController) {
		super();
		this.noteService = noteService;
		this.globalController = globalController;
	}

	@PostMapping("/note/saveNote")
    public String saveTodo(@ModelAttribute("reqNote") Note reqNote,
                           final RedirectAttributes redirectAttributes) {
        logger.info("/note/save");
        try {
        	reqNote.setCreateDate(LocalDateTime.now());
        	reqNote.setLastUpdateDate(LocalDateTime.now());
        	reqNote.setStatus(Status.ACTIVE.getValue());
        	reqNote.setUserId(globalController.getLoginUser().getId());
            noteService.save(reqNote);
            redirectAttributes.addFlashAttribute("msg", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msg", "fail");
            logger.error("save: " + e.getMessage());
        }

        return "redirect:/home";
    }

    @PostMapping("/note/editNote")
    public String editTodo(@ModelAttribute("editNote") Note editNote, Model model) {
        logger.info("/note/editNote");
        try {
            Note note = noteService.findById(editNote.getId());
            if (!note.equals(editNote)) {
            	editNote.setLastUpdateDate(LocalDateTime.now());
                noteService.update(editNote);
                model.addAttribute("msg", "success");
            } else {
                model.addAttribute("msg", "same");
            }
        } catch (Exception e) {
            model.addAttribute("msg", "fail");
            logger.error("editNoteMessage: " + e.getMessage());
        }
        model.addAttribute("editNote", editNote);
        return "edit";
    }


    @GetMapping("/note/{operation}/{id}")
    public String todoOperation(@PathVariable("operation") String operation,
                                @PathVariable("id") int id, final RedirectAttributes redirectAttributes,
                                Model model) {

        logger.info("/note/operation: {} ", operation);
        if (operation.equals("trash")) {
            Note note = noteService.findById(id);
            if (note != null) {
                note.setStatus(Status.PASSIVE.getValue());
                noteService.update(note);
                redirectAttributes.addFlashAttribute("msg", "trash");
            } else {
                redirectAttributes.addFlashAttribute("msg", "notfound");
            }
        }
        if (operation.equals("restore")) {
            Note note = noteService.findById(id);
            if (note != null) {
                note.setStatus(Status.ACTIVE.getValue());
                noteService.update(note);
                redirectAttributes.addFlashAttribute("msg", "active");
                redirectAttributes.addFlashAttribute("msgText", "Note " + note.getTitle() + " Restored Successfully.");
            } else {
                redirectAttributes.addFlashAttribute("msg", "active_fail");
                redirectAttributes.addFlashAttribute("msgText", "Note Activation failed !!! Note:" + note.getTitle());

            }
        } else if (operation.equals("delete")) {
            if (noteService.delete(id)) {
                redirectAttributes.addFlashAttribute("msg", "del");
                redirectAttributes.addFlashAttribute("msgText", " Note deleted permanently");
            } else {
                redirectAttributes.addFlashAttribute("msg", "del_fail");
                redirectAttributes.addFlashAttribute("msgText", " Note could not deleted. Please try later");
            }
        } else if (operation.equals("edit")) {
            Note editNote = noteService.findById(id);
            if (editNote != null) {
                model.addAttribute("editNote", editNote);
                return "edit";
            } else {
                redirectAttributes.addFlashAttribute("msg", "notfound");
            }
        }
        else if (operation.equals("view")) {
            Note viewNote = noteService.findById(id);
            if (viewNote != null) {
                model.addAttribute("viewNote", viewNote);
                return "view";
            } else {
                redirectAttributes.addFlashAttribute("msg", "notfound");
            }
        }
        return "redirect:/home";
    }
}
