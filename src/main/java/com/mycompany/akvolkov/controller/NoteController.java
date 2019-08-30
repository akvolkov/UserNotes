package com.mycompany.akvolkov.controller;

import com.mycompany.akvolkov.entity.Note;
import com.mycompany.akvolkov.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NoteController {
    private NoteService noteService;

    @Autowired
    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping(value = "/")
    public ModelAndView allNotes() {
        List<Note> notesList = noteService.allNotes();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("notes");
        modelAndView.addObject("notesList", notesList);
        return modelAndView;
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") int id) {
        Note note = noteService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("note", note);
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView editNote(@ModelAttribute("note") Note note) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        noteService.edit(note);
        return modelAndView;
    }

    @GetMapping(value = "/add")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView addNote(@ModelAttribute("note") Note note) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        noteService.add(note);
        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteNote(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Note note = noteService.getById(id);
        noteService.delete(note);
        return modelAndView;
    }

    @GetMapping(value = "/description/{id}")
    public ModelAndView descriptionPage(@PathVariable("id") int id) {
        Note note = noteService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("description");
        modelAndView.addObject("note", note);
        return modelAndView;
    }
}
