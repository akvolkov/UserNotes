package com.mycompany.akvolkov.mapper;

import com.mycompany.akvolkov.entity.Note;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class NoteMapper implements RowMapper<Note> {

    @Override
    public Note mapRow(ResultSet resultSet, int i) throws SQLException {
        Note note = new Note();
        note.setId(resultSet.getInt("id"));
        note.setTitle(resultSet.getString("title"));
        note.setDescription(resultSet.getString("description"));
        note.setAuthor(resultSet.getString("author"));
        return note;
    }
}
