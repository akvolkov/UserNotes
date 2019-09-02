package com.mycompany.akvolkov.dao;

import com.mycompany.akvolkov.entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    User getById(int id);
    User getByLogin(String login);
    List<User> getAllUsers();
}
