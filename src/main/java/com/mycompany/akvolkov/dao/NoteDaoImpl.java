package com.mycompany.akvolkov.dao;

import com.mycompany.akvolkov.entity.Note;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class NoteDaoImpl implements NoteDao {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, Note> notes = new HashMap<>();
    static {
        Note note1 = new Note();
        note1.setId(AUTO_ID.getAndIncrement());
        note1.setTitle("title1");
        note1.setAuthor("Aleksey Volkov1");
        note1.setDescription("Description1");
        notes.put(note1.getId(), note1);
        Note note2 = new Note();
        note2.setId(AUTO_ID.getAndIncrement());
        note2.setTitle("title2");
        note2.setAuthor("Aleksey Volkov2");
        note2.setDescription("Description2");
        notes.put(note2.getId(), note2);
        // + film2, film3, film4, ...
    }

    @Override
    public List<Note> allNotes() {
        return new ArrayList<>(notes.values());
    }

    @Override
    public void add(Note note) {
        note.setId(AUTO_ID.getAndIncrement());
        notes.put(note.getId(), note);
    }

    @Override
    public void delete(Note note) {
        notes.remove(note.getId());
    }

    @Override
    public void edit(Note note) {
        notes.put(note.getId(), note);
    }

    @Override
    public Note getById(int id) {
        return notes.get(id);
    }
}
