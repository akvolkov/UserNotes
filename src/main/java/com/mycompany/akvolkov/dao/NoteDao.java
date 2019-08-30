package com.mycompany.akvolkov.dao;

import com.mycompany.akvolkov.entity.Note;

import java.util.List;

public interface NoteDao {
    List<Note> allNotes();
    void add(Note note);
    void delete(Note note);
    void edit(Note note);
    Note getById(int id);
}
