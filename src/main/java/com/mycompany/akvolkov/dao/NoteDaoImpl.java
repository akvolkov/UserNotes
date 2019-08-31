package com.mycompany.akvolkov.dao;

import com.mycompany.akvolkov.entity.Note;
import com.mycompany.akvolkov.mapper.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoteDaoImpl implements NoteDao {
   JdbcTemplate jdbcTemplate;

    @Autowired
    public NoteDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Note> allNotes() {
        String sql = "SELECT * FROM notes";
        return jdbcTemplate.query(sql, new NoteMapper());
    }

    @Override
    public void add(Note note) {
        String sql = "INSERT INTO notes (title, description, AUTHOR) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, note.getTitle(), note.getDescription(), note.getAuthor());
    }

    @Override
    public void delete(Note note) {
        String sql = "DELETE FROM notes WHERE id=?";
        jdbcTemplate.update(sql, note.getId());
    }

    @Override
    public void edit(Note note) {
        String sql = "UPDATE notes SET TITLE = ?, DESCRIPTION = ?, AUTHOR = ? WHERE ID = ?";
        jdbcTemplate.update(sql, note.getTitle(), note.getDescription(), note.getAuthor(), note.getId());
    }

    @Override
    public Note getById(int id) {
        String sql = "SELECT * FROM notes where ID = ?";
        return jdbcTemplate.queryForObject(sql, new NoteMapper(), id);
    }
}
