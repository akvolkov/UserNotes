package com.mycompany.akvolkov.service;

import com.mycompany.akvolkov.dao.NoteDao;
import com.mycompany.akvolkov.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    private NoteDao noteDao;

    @Autowired
    public void setNoteDao(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    @Override
    public List<Note> allNotes() {
        return noteDao.allNotes();
    }

    @Override
    public void add(Note note) {
        noteDao.add(note);
    }

    @Override
    public void delete(Note note) {
        noteDao.delete(note);
    }

    @Override
    public void edit(Note note) {
        noteDao.edit(note);
    }

    @Override
    public Note getById(int id) {
        return noteDao.getById(id);
    }
}
