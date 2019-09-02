package com.mycompany.akvolkov.dao;

import com.mycompany.akvolkov.entity.User;
import com.mycompany.akvolkov.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(User user) {
        String sql = "INSERT INTO USERS (login, PASSWORD, AVATAR) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getLogin(), user.getPassword(), user.getAvatar());
    }

    @Override
    public User getById(int id) {
        String sql = "SELECT * FROM USERS where ID = ?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }

    @Override
    public User getByLogin(String login) {
        String sql = "SELECT * FROM USERS where LOGIN = ?";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, new UserMapper(), login);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("User not exists!");
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserMapper());
    }
}
