package com.cursor.hw18.service;

import com.cursor.hw18.model.User;

import java.util.List;

public interface UserService {
    void addUsers(String firstName, String lastName, String username);

    List<User> getAllUsers();
}
