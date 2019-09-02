package com.mycompany.akvolkov.controller;

import com.mycompany.akvolkov.entity.Note;
import com.mycompany.akvolkov.entity.User;
import com.mycompany.akvolkov.service.NoteService;
import com.mycompany.akvolkov.service.UserService;
import com.mycompany.akvolkov.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
public class MainController {
    private NoteService noteService;
    private UserService userService;

    @Autowired
    public void setNoteService(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView greeting() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("greeting");
        return modelAndView;
    }

    @PostMapping("/findByTitle")
    public ModelAndView findByTitle(@ModelAttribute("title")  String title) {
        ModelAndView modelAndView = new ModelAndView();
        Note note = noteService.getByTitle(title);
        modelAndView.addObject("note", note);
        modelAndView.setViewName("description");
        return modelAndView;
    }

    @GetMapping("/notes")
    public ModelAndView allNotes() {
        List<Note> notesList = noteService.allNotes();
        HashMap<String, String> map = new HashMap<>();
        for (Note note: notesList
             ) {
            for (User user: userService.getAllUsers()
                 ) {
                if (note.getAuthor().equals(user.getLogin())) {
                    map.put(note.getAuthor(), user.getAvatar());
                }
            }
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("notes");
        modelAndView.addObject("notesList", notesList);
        modelAndView.addObject("map", map);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") int id) {
        Note note = noteService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("note", note);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editNote(@ModelAttribute("note") Note note) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/notes");
        noteService.edit(note);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addNote(@ModelAttribute("note") Note note) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/notes");
        noteService.add(note);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteNote(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/notes");
        Note note = noteService.getById(id);
        noteService.delete(note);
        return modelAndView;
    }

    @GetMapping("/description/{id}")
    public ModelAndView descriptionPage(@PathVariable("id") int id) {
        Note note = noteService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("description");
        modelAndView.addObject("note", note);
        return modelAndView;
    }

    @GetMapping("/registration")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView addUser(User user) {
        ModelAndView modelAndView = new ModelAndView();
        User userByLogin = userService.getByLogin(user.getLogin());
        if (userByLogin != null) {
            modelAndView.addObject("message", "User exists!");
            modelAndView.setViewName("registration");
        } else {
            user.setAvatar(UserUtils.getAvatar(user.getLogin()));
            userService.add(user);
            modelAndView.setViewName("redirect:/login");
        }
        return modelAndView;
    }

}
