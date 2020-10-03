package com.epam.winterJavaLab.task12.service.interfaces;

import com.epam.winterJavaLab.task12.entity.User;

import java.util.List;


public interface UserService {

    void addUser(User user);

    User getUser(String email);

    List<User> getAllUsers();

}
