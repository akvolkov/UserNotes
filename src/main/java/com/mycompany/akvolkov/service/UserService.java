package com.mycompany.akvolkov.service;

import com.mycompany.akvolkov.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);
    User getById(int id);
    User getByLogin(String login);
    List<User> getAllUsers();
}
